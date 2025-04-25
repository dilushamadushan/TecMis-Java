package app.tecmis.techOfficer;

import java.util.Date;

public class UserMedDetails {
    private String med_Fname;
    private String med_Lname;
    private String med_Officer_id;
    private String med_Email;
    private String med_Address;
    private String med_Gender;
    private String med_NIC;
    private String med_Bod;
    private String med_Role;
    private String med_Dname;

    public UserMedDetails(String med_Fname, String med_Lname, String med_Officer_id, String med_Email, String med_Address, String med_Gender, String med_NIC, String med_Bod, String med_Role, String med_Dname) {
        this.med_Fname = med_Fname;
        this.med_Lname = med_Lname;
        this.med_Officer_id = med_Officer_id;
        this.med_Email = med_Email;
        this.med_Address = med_Address;
        this.med_Gender = med_Gender;
        this.med_NIC = med_NIC;
        this.med_Bod = med_Bod;
        this.med_Role = med_Role;
        this.med_Dname = med_Dname;
    }

    public String getMed_Fname() {
        return med_Fname;
    }

    public String getMed_Lname() {
        return med_Lname;
    }

    public String getMed_Officer_id() {
        return med_Officer_id;
    }

    public String getMed_Email() {
        return med_Email;
    }

    public String getMed_Gender() {
        return med_Gender;
    }

    public String getMed_Address() {
        return med_Address;
    }

    public String getMed_NIC() {
        return med_NIC;
    }

    public String getMed_Bod() {
        return med_Bod;
    }

    public String getMed_Role() {
        return med_Role;
    }

    public String getMed_Dname() {
        return med_Dname;
    }
}
