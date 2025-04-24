package app.tecmis.admin;

public class TimeTableDetails {
    private int ttId;
    private String ttLevel;
    private String ttDep;
    private String ttSem;
    private String ttImgPath;
    private String ttDepName;

    public TimeTableDetails(int ttId, String ttLevel, String ttDep, String ttSem, String ttImgPath,String DepName) {
        this.ttId = ttId;
        this.ttLevel = ttLevel;
        this.ttDep = ttDep;
        this.ttSem = ttSem;
        this.ttImgPath = ttImgPath;
        this.ttDepName = DepName;
    }

    public int getTtId() {
        return ttId;
    }

    public String getTtLevel() {
        return ttLevel;
    }

    public String getTtDep() {
        return ttDep;
    }

    public String getTtSem() {
        return ttSem;
    }

    public String getTtImgPath() {
        return ttImgPath;
    }
    public String getTtDepName() {
        return ttDepName;
    }
}
