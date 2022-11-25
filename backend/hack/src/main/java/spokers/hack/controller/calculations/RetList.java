package spokers.hack.controller.calculations;

public class RetList {
    private String filename;
    private String bestUser;
    public RetList(String filename, String bestUser){
        this.filename = filename;
        this.bestUser =bestUser;

    }

    public String getFilename() {
        return filename;
    }

    public String getBestUser() {
        return bestUser;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setBestUser(String bestUser) {
        this.bestUser = bestUser;
    }
}
