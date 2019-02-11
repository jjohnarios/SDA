import tensorflow as tf
import sys
# Just disables the warning, doesn't enable AVX/FMA
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
# Windows users: You only need to change PATH, rest is platform independent



PATH = sys.argv[1]
FILE_TRAIN=sys.argv[2]
FILE_TEST=sys.argv[3]



# The CSV features in our training & test data
feature_names = ['HGfA','HGaA','HPts/Pld','Helo','AGfA','AGaA','APts/Pld','Aelo']

# Create an input function reading a file using the Dataset API
# Then provide the results to the Estimator API


def my_input_fn(file_path, perform_shuffle=True, repeat_count=1):
    def decode_csv(line):
        parsed_line = tf.decode_csv(line, [[0.], [0.], [0.], [0.], [0.], [0.], [0.], [0.], [0]])
        label = parsed_line[-1]  # Last element is the label
        del parsed_line[-1]  # Delete last element
        features = parsed_line  # Everything but last elements are the features
        d = dict(zip(feature_names, features)), label
        return d

    dataset = (tf.data.TextLineDataset(file_path)  # Read text file
               .skip(1)  # Skip header row
               .map(decode_csv))  # Transform each elem by applying decode_csv fn
    if perform_shuffle:
        # Randomizes input using a window of 256 elements (read into memory)
        dataset = dataset.shuffle(buffer_size=256)
    dataset = dataset.repeat(repeat_count)  # Repeats dataset this # times
    dataset = dataset.batch(32)  # Batch size to use
    iterator = dataset.make_one_shot_iterator()
    batch_features, batch_labels = iterator.get_next()
    return batch_features, batch_labels



# Create the feature_columns, which specifies the input to our model
# All our input features are numeric, so use numeric_column for each one
feature_columns = [tf.feature_column.numeric_column(k) for k in feature_names]

# Create a deep neural network regression classifier
# Use the DNNClassifier pre-made estimator
classifier = tf.estimator.DNNClassifier(
    feature_columns=feature_columns,  # The input features to our model
    hidden_units=[ 20, 20],  # Two layers, each with 20 neurons
    n_classes=3,
    model_dir=PATH)  # Path to where checkpoints etc are stored

# Train our model, use the previously defined function my_input_fn
# Input to training is a file with training example
# Stop training after 16 iterations of train data (epochs)
classifier.train(input_fn=lambda: my_input_fn(FILE_TRAIN, True, 300))

