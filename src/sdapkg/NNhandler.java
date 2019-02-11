/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdapkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Apostolos
 */
public class NNhandler {

    private BuildData buildcsv;
    private League league;
    private String Arg1;
    private String Arg2;
    private String Arg3;
    private String Arg4;
    private String Arg5;
    private String Arg6;

    public NNhandler(League L) {
        league = L;
        buildcsv = new BuildData(L);
        buildcsv.build();
    }

    public void setArgumentPath(String L) {

        Arg1 = "SDAPY/NN" + L;
        Arg2 = "SDAPY/csv/" + L + "TrainSet" + ".csv";
        Arg3 = "SDAPY/csv/" + L + "TestSet" + ".csv";
        Arg4 = "SDAPY/csv/" + L + "PredictSet" + ".csv";
        Arg5 = "SDAPY/GeneralNN";
        Arg6 = "SDAPY/csv/" + L + "PredictSetGeneral" + ".csv";
    }
    // call a python script that create and train the neutral network 
    public boolean train() {
        setArgumentPath(league.getNameInSite1());
        // create the input for the script.
        buildcsv.CreateTrainCsv(Arg2);
        buildcsv.CreateTestCsv(Arg3);
        
        //delete all olders files in the folder of neutral network
        File folder =new File(Arg1);
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
               f.delete(); 
            }
        }
        folder.delete();
        try {

            Process p = Runtime.getRuntime().exec("python nn.py \"" + Arg1 + "\" \"" + Arg2 + "\" \"" + Arg3 + "\"");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (p.isAlive()) {

            }
            return p.exitValue() == 0;
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return false;
    }

    public String predict() {
        setArgumentPath(league.getNameInSite1());
        buildcsv.CreatePredictCsv(Arg4);
        StringBuilder sb = new StringBuilder();
        try {

            Process p = Runtime.getRuntime().exec("python predict.py \"" + Arg1 + "\" \"" + Arg4 + "\"");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (p.isAlive()) {

            }

            String[] s = stdInput.lines().toArray(String[]::new);
            ArrayList<String[]> matches = buildcsv.getPredictMatch();
            int c = 0;
            for (String a : s) {
                sb.append(matches.get(c)[0]).append(" vs ").append(matches.get(c)[1]).append("\n");
                sb.append(a).append("\n");
                c++;
            }

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return sb.toString();

    }

    //returns a string with all teams from league with propabillities 
    public String Generalpredict() {
        setArgumentPath(league.getNameInSite1());
        for (int i = 0; i < league.getNumberOfTeams(); i++) {
            buildcsv.addGeneralPrediction(league.getTeamByIndex(i).getNameInSite1());
        }
        buildcsv.CreatePredictGeneralCsv(Arg6);
        StringBuilder sb = new StringBuilder();
        try {

            Process p = Runtime.getRuntime().exec("python GeneralPredict.py \"" + Arg5 + "\" \"" + Arg6 + "\"");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while (p.isAlive()) {

            }

            String[] s = stdInput.lines().toArray(String[]::new);
            ArrayList<String[]> matches = buildcsv.getPredictMatch();
            int c = 0;
            for (String a : s) {

                sb.append(league.getTeamByIndex(c).getNameInSite1()).append(", ").append(a).append("\n");
                c++;
            }

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return sb.toString();

    }

    public void addPrediction(String home, String away) {
        buildcsv.addPrediction(home, away);
    }

    public void clearPredictions() {
        this.buildcsv.clearPredictions();
    }
}
