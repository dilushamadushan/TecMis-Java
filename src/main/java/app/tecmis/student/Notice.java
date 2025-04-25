package app.tecmis.student;

import java.util.Date;



public class Notice {
    private String date;
    private String notice_title;
    private String description ;

    public Notice(String date, String notice_title, String description){
        this.date = date;
        this.notice_title = notice_title;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public String getDescription() {
        return description;
    }
}