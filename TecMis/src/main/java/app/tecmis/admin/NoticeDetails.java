package app.tecmis.admin;

import java.util.Date;

public class NoticeDetails {
    private int noticeId;
    private String noticeTitle;
    private String noticeDescription;
    private Date noticeDate;
    private String noticePath;

    public NoticeDetails(int noticeId, String noticeTitle, String noticeDescription, Date noticeDate, String noticePath) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeDescription = noticeDescription;
        this.noticeDate = noticeDate;
        this.noticePath = noticePath;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public String getNoticeDescription() {
        return noticeDescription;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public String getNoticePath() {
        return noticePath;
    }
}
