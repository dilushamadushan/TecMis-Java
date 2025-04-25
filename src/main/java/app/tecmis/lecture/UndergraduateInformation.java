package app.tecmis.lecture;

import java.util.Date;

public class UndergraduateInformation {

    private String undergraduateId;
    private String     undergraduateFname;
    private String     undergraduateLname;
    private String     undergraduateEmail;
    private String     undergraduateGender;
    private String     undergraduateAddress;
    private String undergraduateDob;

    public UndergraduateInformation(String undergraduateId, String undergraduateFname, String undergraduateLname, String undergraduateEmail, String undergraduateGender, String getUndergraduateDob, String undergraduateAddress) {
        this.undergraduateId = undergraduateId;
        this.undergraduateFname = undergraduateFname;
        this.undergraduateLname = undergraduateLname;
        this.undergraduateEmail = undergraduateEmail;
        this.undergraduateGender = undergraduateGender;
        this.undergraduateDob = getUndergraduateDob;
        this.undergraduateAddress = undergraduateAddress;
    }

    public String getUndergraduateId() {
        return undergraduateId;
    }

    public String getUndergraduateFname() {
        return undergraduateFname;
    }

    public String getUndergraduateLname() {
        return undergraduateLname;
    }

    public String getUndergraduateEmail() {
        return undergraduateEmail;
    }

    public String getUndergraduateGender() {
        return undergraduateGender;
    }
    public String getUndergraduateDob() {
        return undergraduateDob;
    }

    public void setUndergraduateDob(String undergraduateDob) {
        this.undergraduateDob = undergraduateDob;
    }


    public String getStuFullName() {
        return undergraduateFname + " " + undergraduateLname;
    }
    public String getUndergraduateAddress() {
        return undergraduateAddress;
    }
}
