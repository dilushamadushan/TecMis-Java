package app.tecmis.lecture;

import javafx.beans.property.SimpleStringProperty;

public class EligibilityRecord {
    private final SimpleStringProperty studentId;
    private final SimpleStringProperty courseCode;
    private final SimpleStringProperty attendanceEligibility;
    private final SimpleStringProperty caEligibility;
    private final SimpleStringProperty finalEligibility;

    public EligibilityRecord(String studentId, String courseCode, String attendanceEligibility, String caEligibility, String finalEligibility) {
        this.studentId = new SimpleStringProperty(studentId);
        this.courseCode = new SimpleStringProperty(courseCode);
        this.attendanceEligibility = new SimpleStringProperty(attendanceEligibility);
        this.caEligibility = new SimpleStringProperty(caEligibility);
        this.finalEligibility = new SimpleStringProperty(finalEligibility);
    }

    public String getStudentId() {
        return studentId.get();
    }

    public String getCourseCode() {
        return courseCode.get();
    }

    public String getAttendanceEligibility() {
        return attendanceEligibility.get();
    }

    public String getCaEligibility() {
        return caEligibility.get();
    }

    public String getFinalEligibility() {
        return finalEligibility.get();
    }
}
