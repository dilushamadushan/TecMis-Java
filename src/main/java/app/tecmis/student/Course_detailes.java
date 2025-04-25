package app.tecmis.student;

public class Course_detailes {
   private String course_code;
   private String  course_name;
   private String course_credit;
   private String course_houre;
   private String course_type;

    public Course_detailes(String course_code, String course_name, String course_credit, String course_houre, String course_type) {
        this.course_code = course_code;
        this.course_name = course_name;
        this.course_credit = course_credit;
        this.course_houre = course_houre;
        this.course_type = course_type;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_credit() {
        return course_credit;
    }

    public String getCourse_houre() {
        return course_houre;
    }

    public String getCourse_type() {
        return course_type;
    }
}
