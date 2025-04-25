package app.tecmis.techOfficer;

import java.util.Date;

public class UserEditDetails {
    private String attEditFname;
    private String attEditLname;
    private String attEditOfficer_id;
    private String attEditEmail;
    private String attEditAddress;
    private String attEditGender;
    private String attEditNIC;
    private String attEditBod;
    private String attEditRole;
    private String attEditDname;

    public UserEditDetails(String attEditFname, String attEditLname, String attEditOfficer_id, String attEditEmail, String attEditAddress, String attEditGender, String attEditNIC, String attEditBod, String attEditRole, String attEditDname) {
        this.attEditFname = attEditFname;
        this.attEditLname = attEditLname;
        this.attEditOfficer_id = attEditOfficer_id;
        this.attEditEmail = attEditEmail;
        this.attEditAddress = attEditAddress;
        this.attEditGender = attEditGender;
        this.attEditNIC = attEditNIC;
        this.attEditBod = attEditBod;
        this.attEditRole = attEditRole;
        this.attEditDname = attEditDname;
    }

    public String getAttEditFname() {
        return attEditFname;
    }

    public String getAttEditLname() {
        return attEditLname;
    }

    public String getAttEditOfficer_id() {
        return attEditOfficer_id;
    }

    public String getAttEditEmail() {
        return attEditEmail;
    }

    public String getAttEditAddress() {
        return attEditAddress;
    }

    public String getAttEditGender() {
        return attEditGender;
    }

    public String getAttEditBod() {
        return attEditBod;
    }

    public String getAttEditNIC() {
        return attEditNIC;
    }

    public String getAttEditRole() {
        return attEditRole;
    }

    public String getAttEditDname() {
        return attEditDname;
    }
}
