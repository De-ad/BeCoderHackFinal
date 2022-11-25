package spokers.hack.controller.calculations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Task1Hyp2 {
    public static void sortByCommits(ArrayList<FileInfo> listOfFiles){
        listOfFiles.sort(Comparator.comparing(FileInfo::getCommits));
    }

    public static void printCommitSorted(String username, HashMap<String, ArrayList<FileInfo>> mapOfUsers) {
        ArrayList<FileInfo> listOfFiles = new ArrayList<>(mapOfUsers.get(username));
        sortByCommits(listOfFiles);
        for(FileInfo fileInfo : listOfFiles) {
            System.out.println(fileInfo + "\n");
        }
    }
    public static void printBadCommits(String username, HashMap<String, ArrayList<FileInfo>> mapOfUsers){
        ArrayList<FileInfo> listOfFiles = mapOfUsers.get(username);
        for(FileInfo fileInfo : listOfFiles) {
            System.out.print(fileInfo.getBadCommits() + " ");
        }
        System.out.println();
    }
    public static boolean calculateCommitsVsMistakes(String username, HashMap<String, ArrayList<FileInfo>> mapOfUsers) {
        ArrayList<FileInfo> listOfFiles = mapOfUsers.get(username);
        if(listOfFiles == null)
            return false;
        double awgDif = 0;
        for(FileInfo fileInfo : listOfFiles) {
            double dif = fileInfo.getSuccessPercentage();
            awgDif += dif;
        }
        int count = 0;
        awgDif /= (double) listOfFiles.size();
        for(FileInfo fileInfo : listOfFiles) {
            if(awgDif < fileInfo.getSuccessPercentage()){
                count++;
            }
        }
        return count > listOfFiles.size();
    }
}
