package app.tecmis.techOfficer;

public class ProfileNameMed {
    private String Fname;
    private String Lname;

    public ProfileNameMed(String fname, String lname) {
        Fname = fname;
        Lname = lname;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getMedFullName() {
        return Fname + " " + Lname;
    }
}
