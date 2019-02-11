/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdapkg;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Apostolos
 */
public class BuildData {

    
    private League league;
   
    
    private ArrayList<ArrayList<String>> All;
    private ArrayList<ArrayList<String>> finalStructure;
    private ArrayList<ArrayList<String>> PredictStructure;
    private ArrayList<String[]> PredictMatch;
    private ArrayList<ArrayList<String>> PredictTeamsStructure;
    //Delimiter used in CSV file
 

    //CSV file header
    

    public BuildData(League L) {
        
        this.league=L; 
        All = new ArrayList();
        finalStructure = new ArrayList();
        PredictStructure=new ArrayList();
        PredictMatch=new ArrayList();
        PredictTeamsStructure=new ArrayList();
    }
    public ArrayList<String[]> getPredictMatch(){
        return this.PredictMatch;
    }
    
    
    public void build() {


        this.league.init();
        
        
        for(int i=0;i<league.getNumberOfTeams();i++){
           All.add(new ArrayList());
           Team team=league.getTeamByIndex(i);
           All.get(i).add(team.getNameInSite1());
           All.get(i).add(team.getStatByTitle("GfA"));
           All.get(i).add(team.getStatByTitle("GaA"));
           All.get(i).add(  (Double.parseDouble(team.getStatByTitle("Pts"))/Double.parseDouble(team.getStatByTitle("Pld")))+"");
           All.get(i).add((Double.parseDouble(team.getStatByTitle("Elo"))*0.001+""));
           
            
        }
        

       

        Results games = new Results("http://www.footballresults.org/league.php?all=1&league=" + league.getNameInSite1());

        games.initStats();

        ArrayList<String[]> Results = games.getAllStats();

        for (String[] a : Results) {
            finalStructure.add(new ArrayList<String>());
            int size = finalStructure.size();
            finalStructure.get(size - 1).addAll(getAllByTeam(a[0]));
            finalStructure.get(size - 1).addAll(getAllByTeam(a[1]));
            //0 for win 1 for Draw 2 for Lose
            if (Integer.parseInt(a[2]) > Integer.parseInt(a[3])) {
                finalStructure.get(size - 1).add("0");
            } else if (Integer.parseInt(a[2]) == Integer.parseInt(a[3])) {
                finalStructure.get(size - 1).add("1");
            } else {
                finalStructure.get(size - 1).add("2");
            }

        }
    }
    
    public void addGeneralPrediction(String t){
        this.PredictTeamsStructure.add(new ArrayList());
        Team team=league.getTeamByIndex(league.getIndexOfTeamByName(t));
        int size=PredictTeamsStructure.size();
        PredictTeamsStructure.get(size-1).add(team.getStatByTitle("Elo"));
        PredictTeamsStructure.get(size-1).add(  (Double.parseDouble(team.getStatByTitle("Pts"))/Double.parseDouble(team.getStatByTitle("Pld")))+"");
        PredictTeamsStructure.get(size-1).add(team.getStatByTitle("GfA"));
        PredictTeamsStructure.get(size-1).add(team.getStatByTitle("GaA"));
    }
    public void addPrediction(String home,String Away){
        String[] match={home,Away};
        PredictMatch.add(match);
        PredictStructure.add(new ArrayList());
        int size = PredictStructure.size();
        PredictStructure.get(size - 1).addAll(getAllByTeam(home));
        PredictStructure.get(size - 1).addAll(getAllByTeam(Away));
    }
    private ArrayList<String> getAllByTeam(String Team) {
        for (int i = 0; i < this.All.size(); i++) {
            if (All.get(i).get(0).equals(Team)) {
                ArrayList<String> temp = new ArrayList(All.get(i));
                temp.remove(0);
                return temp;
            }
        }
        ArrayList<String> fail = new ArrayList<String>();
        fail.add("-1");
        return fail;
    }

    public void showData() {
        System.out.println("HGfA,HGaA,HPts/Pld,Helo,AGfA,AGaA,APts/Pld,Aelo");

        for (int j = 0; j < finalStructure.size(); j++) {

            for (int i = 0; i < finalStructure.get(j).size() - 1; i++) {
                System.out.print(finalStructure.get(j).get(i) + ",");
            }
            System.out.print(finalStructure.get(j).get(finalStructure.get(j).size() - 1));
            if (j != finalStructure.size() - 1) {
                System.out.println("");
            }
        }
    }

    public void CreateTrainCsv(String fileName) {
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append("HGfA,HGaA,HPts/Pld,Helo,AGfA,AGaA,APts/Pld,Aelo\n");

            for (int j = 0; j < finalStructure.size(); j++) {
                for (int i = 0; i < finalStructure.get(j).size() - 1; i++) {
                    fileWriter.append(finalStructure.get(j).get(i) + ",");
                }
                fileWriter.append(finalStructure.get(j).get(finalStructure.get(j).size() - 1));
                if (j != finalStructure.size() - 1) {
                    fileWriter.append("\n");
                }
            }

          

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
    public void CreateTestCsv(String fileName) {
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append("HGfA,HGaA,HPts/Pld,Helo,AGfA,AGaA,APts/Pld,Aelo\n");

            for (int j = 0; j <45; j++) {
                for (int i = 0; i < finalStructure.get(j).size() - 1; i++) {
                    fileWriter.append(finalStructure.get(j).get(i) + ",");
                }
                fileWriter.append(finalStructure.get(j).get(finalStructure.get(j).size() - 1));
                if (j != finalStructure.size() - 1) {
                    fileWriter.append("\n");
                }
            }

            

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
    public void CreatePredictCsv(String fileName) {
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append("HGfA,HGaA,HPts/Pld,Helo,AGfA,AGaA,APts/Pld,Aelo\n");

            for (int j = 0; j <PredictStructure.size(); j++) {
                for (int i = 0; i < PredictStructure.get(j).size() - 1; i++) {
                    fileWriter.append(PredictStructure.get(j).get(i) + ",");
                }
                fileWriter.append(PredictStructure.get(j).get(PredictStructure.get(j).size() - 1));
                if (j != PredictStructure.size() - 1) {
                    fileWriter.append("\n");
                }
            }

           

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
    
     public void CreatePredictGeneralCsv(String fileName) {
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append("Elo,Pts/Pld,GfA,GaA\n");

            for (int j = 0; j <PredictTeamsStructure.size(); j++) {
                for (int i = 0; i < PredictTeamsStructure.get(j).size() - 1; i++) {
                    fileWriter.append(PredictTeamsStructure.get(j).get(i) + ",");
                }
                fileWriter.append(PredictTeamsStructure.get(j).get(PredictTeamsStructure.get(j).size() - 1));
                if (j != PredictTeamsStructure.size() - 1) {
                    fileWriter.append("\n");
                }
            }

           

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
     
     public void clearPredictions(){
         this.PredictMatch.clear();
         this.PredictStructure.clear();
     }
 

}
