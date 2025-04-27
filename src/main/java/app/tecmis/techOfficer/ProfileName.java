package app.tecmis.techOfficer;

public class ProfileName {
    private String Fname;
    private String Lname;

    public ProfileName(String fname, String lname) {
        Fname = fname;
        Lname = lname;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getAttFullName() {
        return Fname + " " + Lname;
    }
}

