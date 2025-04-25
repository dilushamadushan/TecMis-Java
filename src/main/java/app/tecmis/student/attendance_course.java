package app.tecmis.student;

public class attendance_course {

    private String course_name ;

    private String course_code;

    public attendance_course(String courseName, String course_code) {
        this.course_name = courseName;
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;}

    public String getCourse_code() {
        return course_code;
    }
}


