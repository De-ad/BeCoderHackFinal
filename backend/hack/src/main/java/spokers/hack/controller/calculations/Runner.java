package spokers.hack.controller.calculations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Runner {
    public static void printMap(HashMap<String, ArrayList<FileInfo>> mapOfUsers){
        for (Map.Entry<String, ArrayList<FileInfo>> entry : mapOfUsers.entrySet()) {
            ArrayList<FileInfo> arrayList = entry.getValue();

            System.out.println(entry.getKey() + "/");
            for(FileInfo a : arrayList){
                System.out.println(a + " ");
            }
            System.out.println("\n");
        }
    }
    public static ArrayList<RetList> run(String url) throws IOException {
        ArrayList<String> users = new ArrayList<>();
        HashMap<String, ArrayList<FileInfo>>mapOfUsers = new HashMap<>();
        ArrayList<FileInfo> tempa1 = new ArrayList<>();
        mapOfUsers.put("0", tempa1);
        //tempa.add(new FileInfo("qweqwe", 8, 7, 1));
        //tempa.add(new FileInfo("eeee", 3, 2, 1));
        //tempa.add(new FileInfo("ttt", 5, 1, 4));

        Process p = Runtime.getRuntime().exec("python3 main.py " + url);
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(p.getInputStream()));
        String s;
        while((s = stdInput.readLine()) != null) {
            //System.out.println(s);
            String[] lineArr = s.split("#");
            String username = lineArr[0];
            String filename = lineArr[1];
            boolean fail = !Objects.equals(lineArr[2], "False");

            lineArr[3] = lineArr[3].replaceAll("-|:|Z|T", " ");
            String[] dateArr = lineArr[3].split(" ");
            Date date = new Date(
                    Integer.parseInt(dateArr[0]),
                    Integer.parseInt(dateArr[1]),
                    Integer.parseInt(dateArr[2]),
                    Integer.parseInt(dateArr[3]),
                    Integer.parseInt(dateArr[4]),
                    Integer.parseInt(dateArr[5])
            );

            if(!users.contains(username)){
                users.add(username);
            }

            ArrayList<FileInfo> fileInfoArray = mapOfUsers.get(username);
            if(fileInfoArray == null) {
                ArrayList<FileInfo> a = new ArrayList<>();
                a.add(new FileInfo(filename,0, 0, 0));
                mapOfUsers.put(username, a);
                fileInfoArray = mapOfUsers.get(username);
            }
            for(FileInfo fileInfo : fileInfoArray) {
                if(Objects.equals(fileInfo.getFilename(), filename)){
                    if(fail){
                        fileInfo.incBad();
                    }
                    else
                        fileInfo.incGood();
                    fileInfo.incCommits();
                }
            }

        }

        //System.out.println("Hyp1: ");

        int count = 0;
        for(String username : users) {
            ArrayList<String> worstFiles = Task1Hyp1.findWorstFiles(username, mapOfUsers);
            for(String filename : worstFiles){
                System.out.println(filename);
            }
            if(Task1Hyp1.calculateLearning(username, mapOfUsers))
                count++;
        }
        System.out.println(users.size()/2 >= count);


        //System.out.println("\nHyp2: ");
        //Task1Hyp2.printCommitSorted("user", mapOfUsers);
        //Task1Hyp2.printBadCommits("user", mapOfUsers);
        int count1 = 0;
        for(String username : users){
            if(Task1Hyp2.calculateCommitsVsMistakes(username, mapOfUsers))
                count1++;

        }
        System.out.println(users.size()/2 >= count1);

        //System.out.println("\nTask2: ");
        ArrayList<String> highPriorityFiles = new ArrayList<>();
        for(String username : users) {
            highPriorityFiles = Task2.findHighPriorityFiles(username, mapOfUsers);
        }
        ArrayList<RetList> ret = new ArrayList<>();

        for(String filename : highPriorityFiles){
            RetList retList = new RetList(filename, Task2.findBestUser(filename, mapOfUsers));
            ret.add(retList);
            //ret += filename + Task2.findBestUser(filename, mapOfUsers) + "\n";
            //System.out.println(filename + "   Best user: " + Task2.findBestUser(filename, mapOfUsers));
        }
        return ret;
    }
}
