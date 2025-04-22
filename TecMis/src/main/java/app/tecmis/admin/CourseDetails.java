package app.tecmis.admin;

public class CourseDetails {
    private String courseName;
    private String courseCode;
    private int courseCredit;
    private int courseHoures;
    private String courseType;
    private String courseDepartment;

    public CourseDetails( String courseCode,String courseName,
                         int courseCredit, int courseHoures,
                         String courseType, String courseDepartment) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
        this.courseHoures = courseHoures;
        this.courseType = courseType;
        this.courseDepartment = courseDepartment;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public int getCourseHoures() {
        return courseHoures;
    }

    public String getCourseType() {
        return courseType;
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }
}
