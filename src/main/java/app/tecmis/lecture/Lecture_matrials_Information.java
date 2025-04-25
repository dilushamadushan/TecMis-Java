package app.tecmis.lecture;

public class Lecture_matrials_Information {

    private String course_code;
    private String lecture_id;
    private String session;
    private  String file_path;

    public Lecture_matrials_Information(String course_code, String lecture_id, String session, String file_path) {
        this.course_code = course_code;
        this.lecture_id = lecture_id;
        this.session = session;
        this.file_path = file_path;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getLecture_id() {
        return lecture_id;
    }

    public String getSession() {
        return session;
    }

    public String getFile_path() {
        return file_path;
    }
}
