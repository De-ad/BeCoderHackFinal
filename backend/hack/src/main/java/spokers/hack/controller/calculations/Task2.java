package spokers.hack.controller.calculations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static ArrayList<String> findHighPriorityFiles(String username, HashMap<String, ArrayList<FileInfo>> mapOfUsers) {
        if(mapOfUsers.get(username) == null)
            return new ArrayList<>();
        ArrayList<FileInfo> listOfFiles = new ArrayList<>(mapOfUsers.get(username));

        ArrayList<String> highPriorityFiles = new ArrayList<>();
        for(FileInfo fileInfo : listOfFiles) {
            if(fileInfo.getSuccessPercentage() < 10) {
                highPriorityFiles.add(fileInfo.getFilename());
            }
        }
        return highPriorityFiles;
    }
    public static String findBestUser(String filename, HashMap<String, ArrayList<FileInfo>> mapOfUsers){
        String bestUser = "";
        double b = 0;
        for (Map.Entry<String, ArrayList<FileInfo>> entry : mapOfUsers.entrySet()) {
            ArrayList<FileInfo> fileInfoArray = entry.getValue();
            for(FileInfo fileInfo : fileInfoArray){
                if(fileInfo.getFilename() == filename){
                    if(fileInfo.getSuccessPercentage() > b) {
                        bestUser = entry.getKey();
                        b = fileInfo.getSuccessPercentage();
                    }
                }
            }
            //System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        return bestUser;
    }
}
