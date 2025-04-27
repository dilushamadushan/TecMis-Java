package app.tecmis.lecture;

public class Attendance_Information {

    private String tg_number;
    private String attendance_date;
    private String theory_practical_attendance;
    private String status_attendance;

    public Attendance_Information(String tg_number, String attendance_date, String theory_practical_attendance, String status_attendance) {
        this.tg_number = tg_number;
        this.attendance_date = attendance_date;
        this.theory_practical_attendance = theory_practical_attendance;
        this.status_attendance = status_attendance;
    }

    public String getTg_number() {
        return tg_number;
    }

    public String getAttendance_date() {
        return attendance_date;
    }

    public String getTheory_practical_attendance() {
        return theory_practical_attendance;
    }

    public String getStatus_attendance() {
        return status_attendance;
    }
}
