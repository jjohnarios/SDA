
package sdapkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ioannis
 */
public class League {
    
    private ArrayList<Team> teams;
    private String nameInSite1;
    private String nameInSite2;
    private String url1;
    private String url2;
    private String url3;
    private boolean isInit;
    private ReadEloNames elonames;
    
    public League(String nameInSite1,ReadEloNames re,String url1,String url2,String url3) throws FileNotFoundException{
        this.nameInSite1=nameInSite1;
        isInit=false;
        teams=new ArrayList<>();
        elonames=re;
        this.url1=url1;
        this.url2=url2;
        this.url3=url3;
    }

    public String getNameInSite1() {
        return nameInSite1;
    }

    public String getNameInSite2() {
        return nameInSite2;
    }
    
    
    public void findSecondName() throws FileNotFoundException{
         Scanner scan=new Scanner(new File("eloLeagueNames.txt"));
        while(scan.hasNext()){
            String line=scan.nextLine();
            if(line.contains(nameInSite1)){
                String[] teams=line.split(",");
                nameInSite2=teams[1];
            }
        }
    }
    public void init(){
        if(isInit)return;
        isInit=true;
        try {
            
            final Document document= Jsoup.connect(url1).get();
            Elements Tables=document.select("table.borrsoft"); 
            Elements rows = Tables.get(2).select("tr");//exei 3 borrsoft
           for(Element t:rows){
               ArrayList<String> temp=new ArrayList<>(Arrays.asList(t.text().split(" ")));
               if(temp.get(1).equals("Team")){
                   continue;
               }
              
               Team team=new Team(temp.get(1),elonames.getSecondName(temp.get(1)));
               temp.remove(1);
               String s=temp.get(5)+temp.get(6)+temp.get(7);
               temp.remove(5);
               temp.remove(5);
               temp.remove(5);
               temp.add(5,s);
               team.setStats(temp);
               teams.add(team);
               
           }
            
            
        } catch (IOException ex) {
            Logger.getLogger(League.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         try {
            final Document document = Jsoup.connect(url2).get();
            Elements Tables=document.select("table.liste"); 
            Elements Tr = Tables.get(0).select("tr");
            for(Element a : Tr){ 
                Elements tdl=a.select("td.l");
                if(tdl.size()!=1)continue;
                Elements tdr=a.select("td.r");
                if(tdl.size()!=1)continue;
                
                String name="";
                String elo="";
                if(tdl.size()>0 && tdr.size()>0 && tdl.get(0).select("a").size()>0){
                name=tdl.get(0).select("a").get(0).text();
                
                elo=tdr.get(0).text();
                int namereal=this.getIndexOfTeamByEloName(name);
                   
                if(namereal<0)continue;// is team in anoithew league
                
                teams.get(namereal).addStat(elo);
                }
                
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         initSeq();
    
    }
    
    //init sequence
    private void initSeq(){
        try{
           
        final Document document= Jsoup.connect(url3).get();
            Elements Tables=document.select("table.borrsoft");
            //System.out.print(Tables.size());
            for(Element el:Tables){
                Elements tdNames=el.getElementsByClass("cell1");
                Elements tdNumber=el.getElementsByClass("cell2");
                for(int i=0;i<tdNames.size();i++){
                int ind=getIndexOfTeamByName(tdNames.get(i).text());
                    //System.out.println(tdNames.get(i).text());
                teams.get(ind).addSeq(tdNumber.get(i).text().split(" ")[0]);
                        }
            }
            
           
        }
           catch(Exception E){
                   }
        
    }
    
    public int getIndexOfTeamByName(String name){
        for(int i=0;i<teams.size();i++){
            
            if(name.equals(teams.get(i).getNameInSite1())){
                return i;
            }
        }
        return -1;
    }
    
    public int getIndexOfTeamByEloName(String name){
        for(int i=0;i<teams.size();i++){
            
            if(name.equals(teams.get(i).getNameInSite2())){
                return i;
            }
        }
        return -1;
    }
    
    //1rst sites' names
    //split by " "
    public String getNamesOfTeams(){
        StringBuilder st=new StringBuilder();
        for(Team team: teams){
            //System.out.println(team.getNameInSite1());
            st.append(team.getNameInSite1()).append(" ");
        }
        return st.toString();
    }
    
    //kanto String meta gia gui
    public void showAlL(){
        System.out.println("Team Pos Pld W D L Gf:Ga +/- Pts GfA GaA Elo W  W D ND L U");
        for(Team team:teams){
            //System.out.print(team.getNameInSite1()+" ");
            System.out.println(team.getNameInSite1()+" "+team.getStats()+" "+team.getSeq());
        }
    }
    
    public Team getTeamByIndex(int i){
        return teams.get(i);
    }
    
    public int getNumberOfTeams(){
        return teams.size();
    }
    
    public ArrayList<String> getAllTeamsNames(){
        ArrayList<String> t=new ArrayList();
        for(Team t1: this.teams){
            t.add(t1.getNameInSite1());
        }
        return t;
    }
}
