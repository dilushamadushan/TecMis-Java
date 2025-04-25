package app.tecmis.techOfficer;

public class MedicalTONotice {
    private String notice_id;
    private String notice_date;
    private String notice_title;
    private String notice_descr;

    public MedicalTONotice(String notice_id, String notice_date, String notice_title, String notice_descr) {
        this.notice_id = notice_id;
        this.notice_date = notice_date;
        this.notice_title = notice_title;
        this.notice_descr = notice_descr;
    }

    public String getNotice_id() {
        return notice_id;
    }

    public String getNotice_date() {
        return notice_date;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public String getNotice_descr() {
        return notice_descr;
    }
}
