package app.tecmis.techOfficer;

import java.util.Date;

public class UserDetails {
    private String attFname;
    private String attLname;
    private String attOfficer_id;
    private String attEmail;
    private String attAddress;
    private String attGender;
    private String attNIC;
    private String attBod;
    private String attRole;
    private String attDname;

    public UserDetails(String attFname, String attLname, String attOfficer_id, String attEmail, String attAddress, String attGender, String attNIC, String attBod, String attRole, String attDname) {
        this.attFname = attFname;
        this.attLname = attLname;
        this.attOfficer_id = attOfficer_id;
        this.attEmail = attEmail;
        this.attAddress = attAddress;
        this.attGender = attGender;
        this.attNIC = attNIC;
        this.attBod = attBod;
        this.attRole = attRole;
        this.attDname = attDname;
    }

    public String getAttFname() {
        return attFname;
    }

    public String getAttLname() {
        return attLname;
    }

    public String getAttOfficer_id() {
        return attOfficer_id;
    }

    public String getAttEmail() {
        return attEmail;
    }

    public String getAttAddress() {
        return attAddress;
    }

    public String getAttGender() {
        return attGender;
    }

    public String getAttNIC() {
        return attNIC;
    }

    public String getAttBod() {
        return attBod;
    }

    public String getAttRole() {
        return attRole;
    }

    public String getAttDname() {
        return attDname;
    }
}
