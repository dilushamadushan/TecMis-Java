package app.tecmis.student;

public class Greads {
    private String course_code;
    private String final_mark;

    public Greads(String course_code, String final_mark) {
        this.course_code = course_code;
        this.final_mark = final_mark;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getFinal_mark() {
        return final_mark;
    }
}
