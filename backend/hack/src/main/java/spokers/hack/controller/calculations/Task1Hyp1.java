package spokers.hack.controller.calculations;

import java.util.ArrayList;
import java.util.HashMap;

public class Task1Hyp1 {
    public static ArrayList<Double> getPercentageArray(ArrayList<FileInfo> listOfFiles){
        ArrayList<Double> mistakes = new ArrayList<>();
        for(FileInfo fileInfo : listOfFiles) {
            mistakes.add(fileInfo.getSuccessPercentage());
        }
        return mistakes;
    }
    private static double calculateAwgMistake(ArrayList<Double> successPercentageArray){
        double awg = 0;
        for(Double d : successPercentageArray){
            awg += d;
        }
        return awg / (double)successPercentageArray.size();
    }
    public static ArrayList<String> findWorstFiles(String username, HashMap<String, ArrayList<FileInfo>> mapOfUsers) {
        ArrayList<FileInfo> listOfFiles = mapOfUsers.get(username);
        if(listOfFiles == null)
            return new ArrayList<>();
        ArrayList<Double> percentageArray = getPercentageArray(listOfFiles);
        double awg = calculateAwgMistake(percentageArray);

        ArrayList<String> worstFiles = new ArrayList<>();
        for(FileInfo fileInfo : listOfFiles) {
            if(awg / fileInfo.getSuccessPercentage() >= 2)
                worstFiles.add(fileInfo.getFilename());
        }
        return worstFiles;
    }
    public static ArrayList<Integer> getMistakesArray(ArrayList<FileInfo> listOfFiles){
        ArrayList<Integer> mistakes = new ArrayList<>();
        if(listOfFiles == null)
            return new ArrayList<>();
        for(FileInfo fileInfo : listOfFiles) {
            mistakes.add(fileInfo.getBadCommits());
        }
        return mistakes;
    }
    public static boolean calculateLearning(String username, HashMap<String, ArrayList<FileInfo>> mapOfUsers){
        ArrayList<FileInfo> listOfFiles = mapOfUsers.get(username);
        ArrayList<Integer> mistakes = getMistakesArray(listOfFiles);
        if(mistakes.size() == 1)
            return true;
        int pos = 0;
        int neg = 0;
        for(int i = 1; i < mistakes.size(); i++){
            if(mistakes.get(i) - mistakes.get(i-1) > 0)
                pos++;
            else
                neg++;
        }
        return neg < pos;
    }
}
