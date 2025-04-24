package app.tecmis.lecture;

import java.util.Date;

public class UndergraduateInformation {

    private String undergraduateId;
    private String     undergraduateFname;
    private String     undergraduateLname;
    private String     undergraduateEmail;
    private String     undergraduateGender;
    private Date         getUndergraduateDob;
    private String     undergraduateAddress;

    public UndergraduateInformation(String undergraduateId, String undergraduateFname, String undergraduateLname, String undergraduateEmail, String undergraduateGender, Date getUndergraduateDob, String undergraduateAddress) {
        this.undergraduateId = undergraduateId;
        this.undergraduateFname = undergraduateFname;
        this.undergraduateLname = undergraduateLname;
        this.undergraduateEmail = undergraduateEmail;
        this.undergraduateGender = undergraduateGender;
        this.getUndergraduateDob = getUndergraduateDob;
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

    public Date getGetUndergraduateDob() {
        return getUndergraduateDob;
    }

    public String getStuFullName() {
        return undergraduateFname + " " + undergraduateLname;
    }
    public String getUndergraduateAddress() {
        return undergraduateAddress;
    }
}
