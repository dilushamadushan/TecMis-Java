package app.tecmis.lecture;

public class CourseInformation {
    private String course_name;
    private String course_code;
    private int course_credit;
    private int course_houres;
    private String course_type;


    public CourseInformation(String course_name, String course_code, int course_credit, int course_houres, String course_type) {
        this.course_name = course_name;
        this.course_code = course_code;
        this.course_credit = course_credit;
        this.course_houres = course_houres;
        this.course_type = course_type;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public int getCourse_credit() {
        return course_credit;
    }

    public int getCourse_houres() {
        return course_houres;
    }

    public String getCourse_type() {
        return course_type;
    }
}
