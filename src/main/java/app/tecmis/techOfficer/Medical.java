package app.tecmis.techOfficer;

import java.util.Date;

public class Medical {
    private String student_id;
    private String medical_id;
    private String course_code;
    private Date s_date;
    private Date e_date;
    private String description;
    private String tech_officer_id;
    private String m_report_path;

    public Medical(String student_id, String medical_id,
                   String course_code, Date s_date, Date e_date,
                   String description, String tech_officer_id, String m_report_path) {
        this.student_id = student_id;
        this.medical_id = medical_id;
        this.course_code = course_code;
        this.s_date = s_date;
        this.e_date = e_date;
        this.description = description;
        this.tech_officer_id = tech_officer_id;
        this.m_report_path = m_report_path;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getMedical_id() {
        return medical_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public Date getE_date() {
        return e_date;
    }

    public Date getS_date() {
        return s_date;
    }

    public String getDescription() {
        return description;
    }

    public String getM_report_path() {
        return m_report_path;
    }

    public String getTech_officer_id() {
        return tech_officer_id;
    }
}
