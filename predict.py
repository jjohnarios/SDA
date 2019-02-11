import tensorflow as tf
import sys
# Just disables the warning, doesn't enable AVX/FMA
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

FILE_PREDICT=sys.argv[2]
PATH=sys.argv[1]

feature_names = ['HGfA','HGaA','HPts/Pld','Helo','AGfA','AGaA','APts/Pld','Aelo']
feature_columns = [tf.feature_column.numeric_column(k) for k in feature_names]

# Create a deep neural network regression classifier
# Use the DNNClassifier pre-made estimator
classifier = tf.estimator.DNNClassifier(
    feature_columns=feature_columns,  # The input features to our model
    hidden_units=[ 20, 20],  # Two layers, each with 10 neurons
    n_classes=3,
    model_dir=PATH) 



# Windows users: You only need to change PATH, rest is platform independent
def my_new_input_fn(file_path):
    def decode_csv(line):
        parsed_line = tf.decode_csv(line, [[0.], [0.], [0.], [0.], [0.], [0.], [0.], [0.]])
        
        features = parsed_line  # Everything but last elements are the features
        d = dict(zip(feature_names, features))
        return d

    dataset = (tf.data.TextLineDataset(file_path)  # Read text file
               .skip(1)  # Skip header row
               .map(decode_csv))  # Transform each elem by applying decode_csv fn
    
    dataset = dataset.batch(32)  # Batch size to use
    iterator = dataset.make_one_shot_iterator()
    batch_features = iterator.get_next()
    return batch_features, None


# Predict all our prediction_input
predict_results = classifier.predict(input_fn=lambda: my_new_input_fn(FILE_PREDICT))

# Print results
for r in predict_results:
    	
    idx = r["class_ids"][0]
    if idx == 0 :
        print("Home wins "," 1: ",float("{0:.2f}".format(r["probabilities"][0]))," X: ",float("{0:.2f}".format(r["probabilities"][1])),"2: ",float("{0:.2f}".format(r["probabilities"][2])))
    if idx == 1 : 
        print("Draw "," 1: ",float("{0:.2f}".format(r["probabilities"][0]))," X: ",float("{0:.2f}".format(r["probabilities"][1])),"2: ",float("{0:.2f}".format(r["probabilities"][2])))
    if idx == 2 :
         print("Away wins "," 1: ",float("{0:.2f}".format(r["probabilities"][0]))," X: ",float("{0:.2f}".format(r["probabilities"][1])),"2: ",float("{0:.2f}".format(r["probabilities"][2])))
