package app.tecmis.admin;

import java.util.Date;

public class StudentDetails {
    private String stuId;
    private String stuNic;
    private String stuFname;
    private String stuLname;
    private String stuAddress;
    private String stuEmail;
    private String stuGender;
    private Date stuBod;
    private String stuContactNo;
    private String stuDepName;
    private String stuPassword;

    public StudentDetails(String stuId, String stuNic, String stuFname, String stuLname,
                          String stuAddress, String stuEmail, String stuGender,
                          Date stuBod, String stuContactNo, String stuDepName, String stuPassword) {
        this.stuId = stuId;
        this.stuNic = stuNic;
        this.stuFname = stuFname;
        this.stuLname = stuLname;
        this.stuAddress = stuAddress;
        this.stuEmail = stuEmail;
        this.stuGender = stuGender;
        this.stuBod = stuBod;
        this.stuContactNo = stuContactNo;
        this.stuDepName = stuDepName;
        this.stuPassword = stuPassword;
    }

    public String getStuId() {
        return stuId;
    }

    public String getStuNic() {
        return stuNic;
    }

    public String getStuFname() {
        return stuFname;
    }

    public String getStuLname() {
        return stuLname;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public String getStuGender() {
        return stuGender;
    }

    public Date getStuBod() {
        return stuBod;
    }

    public String getStuContactNo() {
        return stuContactNo;
    }

    public String getStuDepName() {
        return stuDepName;
    }

    public String getStuPassword() {
        return stuPassword;
    }
    public String getStuFullName() {
        return stuFname + " " + stuLname;
    }
}
