package app.tecmis.techOfficer;

import java.util.Date;

public class Attendence {
    private int attendance_id;
    private String attendance_date;
    private String attendance_status;
    private String attendance_SessionType;
    private String attendance_student_id;
    private String attendance_course_code;
    private String attendance_tech_officer_id;

    public Attendence(int attendance_id, String attendance_date, String attendance_status, String attendance_SessionType,
                      String attendance_student_id, String attendance_course_code, String attendance_tech_officer_id) {
        this.attendance_id = attendance_id;
        this.attendance_date = attendance_date;
        this.attendance_status = attendance_status;
        this.attendance_SessionType = attendance_SessionType;
        this.attendance_student_id = attendance_student_id;
        this.attendance_course_code = attendance_course_code;
        this.attendance_tech_officer_id = attendance_tech_officer_id;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public String getAttendance_date() {
        return attendance_date;
    }

    public String getAttendance_status() {
        return attendance_status;
    }

    public String getAttendance_SessionType() {
        return attendance_SessionType;
    }

    public String getAttendance_student_id() {
        return attendance_student_id;
    }

    public String getAttendance_course_code() {
        return attendance_course_code;
    }

    public String getAttendance_tech_officer_id() {
        return attendance_tech_officer_id;
    }
}
