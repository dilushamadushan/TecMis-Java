package app.tecmis.lecture;

public class GPARecord {
    private String studentId;
    private double cgpa;

    public GPARecord(String studentId, double cgpa) {
        this.studentId = studentId;
        this.cgpa = cgpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getCgpa() {
        return cgpa;
    }
}
