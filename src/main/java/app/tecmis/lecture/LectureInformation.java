package app.tecmis.lecture;

import java.util.Date;

public class LectureInformation {
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
    public LectureInformation(String lecId, String lecNic,
                      String lecFname,String lecLname,
                      String lecAddress, String lecEmail,
                      String lecGender, Date lecBod,
                      String lecContactNo, String lecPosition,
                      String lecDepName) {
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
