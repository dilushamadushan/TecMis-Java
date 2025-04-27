package app.tecmis.student;

public class Session {
    private String session_type;
    private String file_path;

    public Session(String session_type, String file_path) {
        this.session_type = session_type;
        this.file_path = file_path;
    }

    public String getSession_type() {
        return session_type;
    }

    public String getFile_path(){
        return file_path;
    }
}
