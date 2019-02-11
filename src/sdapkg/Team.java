package sdapkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ioannis
 */
public class Team {
    
    private String nameInSite1;
    private String nameInSite2;
    private ArrayList<String> stats;
    private ArrayList<String> seq;
    private String prop;
    public String getNameInSite1() {
        return nameInSite1;
    }

    public String getNameInSite2() {
        return nameInSite2;
    }
    //private String url2;
    
    
    Team(String nameInSite1,String nameInSite2) throws FileNotFoundException{
        
        //this.url2=url2;
        this.nameInSite1=nameInSite1;
        this.nameInSite2=nameInSite2;
        //Pos,Pld,W,D,L,Gf:Ga,+/-,Pts,Gfa,GaA,Elo
        stats=new ArrayList<>();
        seq=new ArrayList<>();
    }
    public void setStats(ArrayList<String> S){
        stats.addAll(S);
    }
    public void addSeq(String s){
        seq.add(s);
    }
    Team(String nameInSite1,String nameInSite2,String[] Stats,String[] Seq) throws FileNotFoundException{
        
        //this.url2=url2;
        prop=new String();
        this.nameInSite1=nameInSite1;
        this.nameInSite2=nameInSite2;
        //Pos,Pld,W,D,L,Gf:Ga,+/-,Pts,Gfa,GaA,Elo
        stats=new ArrayList<String>(Arrays.asList(Stats));
        seq=new ArrayList<String>(Arrays.asList(Seq));
    }
    
    public void findSecondName() throws FileNotFoundException{
        Scanner scan=new Scanner(new File("eloTeamNames.txt"));
        while(scan.hasNext()){
            String line=scan.nextLine();
            if(line.contains(nameInSite1)){
                String[] teams=line.split(",");
                nameInSite2=teams[1];
            }
        }
        
    }
    

    public String getStatByTitle(String title){
        switch(title){
            case "Pos":
                return stats.get(0);
            case "Pld":
                return stats.get(1);
            case "W":
                return stats.get(2);
            case "D":
                return stats.get(3);
            case "L":
                return stats.get(4);
            case "Gf:Ga":
                return stats.get(5);
            case "+/-":
                return stats.get(6);
            case "Pts":
                return stats.get(7);
            case "GfA":
                return stats.get(8);
            case "GaA":
                return stats.get(9);
            case "Elo":
                return stats.get(10);
            default:
                return " ";
        }
    }
    //0 winning 1 winless 2 draw 3 not draw 4 losing 5 unbeaten
    public String getSeqById(int index){
        return seq.get(index);
    }
    //Split by " " and you get all of them instead of using the upper method
    public String getStats(){
        StringBuilder allStats=new StringBuilder();
        for(String st: stats){
            allStats.append(st).append(" ");
        }
        return allStats.toString();
    }
    
    public String getSeq(){
         StringBuilder allStats=new StringBuilder();
        for(String st: seq){
            allStats.append(st).append(" ");
        }
        return allStats.toString();
    }
    
    public void addStat(String s){
        stats.add(s);
    }
    
    public void setProp(String prop){
        this.prop=prop;
    }
    
    public String getProp(){
        return this.prop;
    }
}
