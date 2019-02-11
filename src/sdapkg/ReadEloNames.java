package sdapkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class ReadEloNames {
    HashMap<String,String> names;
    
    public ReadEloNames(){
        names=new HashMap<>();
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(ReadEloNames.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void init() throws IOException{
        
        File file=new File("eloTeamNames.txt");
        try {
            BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String st;
            br.readLine();
            while ((st = br.readLine()) != null) {
                String[] line=st.split(",");
                names.put(line[0], line[1]);
        
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadEloNames.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getSecondName(String name){
        return names.get(name);
    }
}