package app.tecmis.student;

public class medical_detalse {

    private String course_code;
    private String student_id;
    private String s_date;
    private String e_date;
    private String description;

    public medical_detalse(String course_code, String student_id, String s_date, String e_date, String description) {
        this.course_code = course_code;
        this.student_id = student_id;
        this.s_date = s_date;
        this.e_date = e_date;
        this.description = description;
    }


    public String getCourse_code() {
        return course_code;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getS_date() {
        return s_date;
    }

    public String getE_date() {
        return e_date;
    }

    public String getDescription() {
        return description;
    }
}
