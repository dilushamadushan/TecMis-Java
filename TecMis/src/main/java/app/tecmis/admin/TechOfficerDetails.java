package app.tecmis.admin;

import java.util.Date;

public class TechOfficerDetails {
    private String toId;
    private String toNic;
    private String toFname;
    private String toLname;
    private String toAddress;
    private String toEmail;
    private String toGender;
    private Date toBod;
    private String toContactNo;
    private String toRole;
    private String toDepName;
    private String toPassword;

    public TechOfficerDetails(String toId, String toNic, String toFname, String toLname,
                              String toAddress, String toEmail,
                              String toGender, Date toBod, String toContactNo,
                              String toRole, String toDepName, String toPassword) {
        this.toId = toId;
        this.toNic = toNic;
        this.toFname = toFname;
        this.toLname = toLname;
        this.toAddress = toAddress;
        this.toEmail = toEmail;
        this.toGender = toGender;
        this.toBod = toBod;
        this.toContactNo = toContactNo;
        this.toRole = toRole;
        this.toDepName = toDepName;
        this.toPassword = toPassword;

    }
    public String getToId() {
        return toId;
    }

    public String getToNic() {
        return toNic;
    }

    public String getToFname() {
        return toFname;
    }

    public String getToLname() {
        return toLname;
    }

    public String getToAddress() {
        return toAddress;
    }

    public String getToEmail() {
        return toEmail;
    }

    public String getToGender() {
        return toGender;
    }

    public Date getToBod() {
        return toBod;
    }

    public String getToContactNo() {
        return toContactNo;
    }

    public String getToRole() {
        return toRole;
    }

    public String getToDepName() {
        return toDepName;
    }

    public String getToPassword() {
        return toPassword;
    }
    public String getToFullName() {
        return toFname + " " + toLname;
    }
}
