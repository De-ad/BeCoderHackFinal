package spokers.hack.controller.calculations;

import java.util.ArrayList;
import java.util.Date;

public class FileInfo{
    private String filename;
    private int commits;
    private int goodCommits;
    private int badCommits;
    private ArrayList<Date> mistakeDates;

    public FileInfo(String filename, int commits, int goodCommits, int badCommits){
        this.filename = filename;
        this.commits = commits;
        this.goodCommits = goodCommits;
        this.badCommits = badCommits;
    }



    public void incCommits(){
        commits++;
    }
    public void incGood(){
        goodCommits++;
    }
    public void incBad(){
        badCommits++;
    }

    public double getSuccessPercentage(){
        return (double)goodCommits/(double)badCommits;
    }
    public String getFilename(){
        return filename;
    }
    public int getCommits(){
        return commits;
    }
    public int getBadCommits(){
        return badCommits;
    }
    public int getGoodCommits(){
        return goodCommits;
    }



    @Override
    public String toString() {
        return "FileInfo{" +
                "filename='" + filename + '\'' +
                ", commits=" + commits +
                ", goodCommits=" + goodCommits +
                ", badCommits=" + badCommits +
                '}';
    }
}