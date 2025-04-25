package app.tecmis.student;

public class attendance {

    private String course_code;
    private String date;
   private String att_state;

    public attendance(String date, String course_code, String att_state) {
        this.date = date;
        this.course_code = course_code;
        this.att_state = att_state;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getDate() {
        return date;
    }

    public String getAtt_state() {
        return att_state;
    }
}
