package app.tecmis.admin;

import java.util.Date;

public class LecDetails {
    private String lecId;
    private String lecNic;
    private String lecFname;
    private String lecLname;
    private String lecAddress;
    private String lecEmail;
    private String lecGender;
    private Date lecBod;
    private String lecContactNo;
    private String lecPosition;
    private String lecDepName;
    private String lecPassword;

    public LecDetails(String lecId, String lecNic,
                      String lecFname,String lecLname,
                      String lecAddress, String lecEmail,
                      String lecGender, Date lecBod,
                      String lecContactNo, String lecPosition,
                      String lecDepName,String lecPassword) {
        this.lecId = lecId;
        this.lecNic = lecNic;
        this.lecFname = lecFname;
        this.lecLname = lecLname;
        this.lecAddress = lecAddress;
        this.lecEmail = lecEmail;
        this.lecGender = lecGender;
        this.lecBod = lecBod;
        this.lecContactNo = lecContactNo;
        this.lecPosition = lecPosition;
        this.lecDepName = lecDepName;
        this.lecPassword = lecPassword;
    }

    public String getLecPassword() {
        return lecPassword;
    }

    public String getLecDepName() {
        return lecDepName;
    }

    public String getLecId() {
        return lecId;
    }

    public String getLecNic() {
        return lecNic;
    }

    public String getLecFname() {
        return lecFname;
    }

    public String getLecLname() {
        return lecLname;
    }

    public String getLecAddress() {
        return lecAddress;
    }

    public String getLecEmail() {
        return lecEmail;
    }

    public String getLecGender() {
        return lecGender;
    }

    public Date getLecBod() {
        return lecBod;
    }

    public String getLecContactNo() {
        return lecContactNo;
    }

    public String getLecPosition() {
        return lecPosition;
    }

    public String getLecFullName() {
        return lecFname + " " + lecLname;
    }
}
