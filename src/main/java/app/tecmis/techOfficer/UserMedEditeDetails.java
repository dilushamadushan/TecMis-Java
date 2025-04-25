package app.tecmis.techOfficer;

import java.util.Date;

public class UserMedEditeDetails {
    private String medEditFname;
    private String medEditLname;
    private String medEditOfficer_id;
    private String medEditEmail;
    private String medEditAddress;
    private String medEditGender;
    private String medEditNIC;
    private String medEditBod;
    private String medEditRole;
    private String medEditDname;

    public UserMedEditeDetails(String medEditFname,String medEditLname,String medEditOfficer_id,String medEditEmail, String medEditAddress, String medEditGender, String medEditNIC, String medEditBod, String medEditRole, String medEditDname) {
        this.medEditFname = medEditFname;
        this.medEditLname = medEditLname;
        this.medEditOfficer_id = medEditOfficer_id;
        this.medEditEmail = medEditEmail;
        this.medEditAddress = medEditAddress;
        this.medEditGender = medEditGender;
        this.medEditNIC = medEditNIC;
        this.medEditBod = medEditBod;
        this.medEditRole = medEditRole;
        this.medEditDname = medEditDname;
    }

    public String getMedEditFname() {
        return medEditFname;
    }

    public String getMedEditLname() {
        return medEditLname;
    }

    public String getMedEditOfficer_id() {
        return medEditOfficer_id;
    }

    public String getMedEditEmail() {
        return medEditEmail;
    }

    public String getMedEditAddress() {
        return medEditAddress;
    }

    public String getMedEditGender() {
        return medEditGender;
    }

    public String getMedEditNIC() {
        return medEditNIC;
    }

    public String getMedEditBod() {
        return medEditBod;
    }

    public String getMedEditDname() {
        return medEditDname;
    }

    public String getMedEditRole() {
        return medEditRole;
    }
}
