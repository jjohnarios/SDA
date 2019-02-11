/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdapkg;



import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Apostolos
 */
public class Results {
    private final String url;
    private ArrayList<String[]> AllStats;
    Results(String url){
        this.url=url;
        AllStats=new ArrayList<>();
    }
    
    public void initStats(){
        try{
            int cols=8;
            final Document document = Jsoup.connect(url).get();
                   
                      String datarow[]=document.select("table.borrsoft").get(5).text().split(" ");
                      
                        for(int j=1;j<datarow.length/cols;j++){ 
                          int k=j*cols-2;
                          AllStats.add(new String[4]);
                          int c=-1;
                          for(int i=k;i<k+cols;i++){
                              if(i-k==2 ||i-k==3 ||i-k==4 ||i-k==6 ){
                                  c++;
                                  AllStats.get(j-1)[c]=datarow[i];
                              }
                           
                          }
                          String[] scor=AllStats.get(j-1)[2].split("-");
                            AllStats.get(j-1)[2]=scor[0];
                            AllStats.get(j-1)[3]=scor[1];
                        }
                      
                      
                 
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getAllStatsString(){
        StringBuilder sb=new StringBuilder();
        for(String[] r : AllStats){
            for(String a : r){
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public ArrayList<String[]> getAllStats(){
        return AllStats;
    }
    
}
