package app.tecmis.lecture;

import java.util.Date;

public class NoticeInformation {


private String  noticeId;
private String  Description;
private Date Date;
private String  noticeTitle;

    public NoticeInformation(String noticeId, String description, Date date, String noticeTitle) {
        this.noticeId = noticeId;
        this.Description  = description;
        this. Date = date;
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public String getDescription() {
        return Description;
    }

    public Date getDate() {
        return Date;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }
}
