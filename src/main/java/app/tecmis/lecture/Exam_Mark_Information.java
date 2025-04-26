package app.tecmis.lecture;

public class Exam_Mark_Information {

    private String tg_number;
    private String course_code;
    private String markId;
    private  Float aS1;
    private  Float aS2;
    private  Float q1;
    private  Float q2;
    private  Float q3;
    private  Float q4;
    private  Float mid;
    private  Float end_T;
    private  Float end_P;


    public Exam_Mark_Information(String tg_number, String course_code, String markId, Float aS1, Float aS2, Float q1, Float q2, Float q3, Float q4, Float mid, Float end_T, Float end_P) {
        this.tg_number = tg_number;
        this.course_code = course_code;
        this.markId = markId;
        this.aS1 = aS1;
        this.aS2 = aS2;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.mid = mid;
        this.end_T = end_T;
        this.end_P = end_P;
    }

    public String getTg_number() {
        return tg_number;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getMarkId() {
        return markId;
    }

    public Float getQ1() {
        return q1;
    }

    public Float getQ2() {
        return q2;
    }

    public Float getQ3() {
        return q3;
    }

    public Float getQ4() {
        return q4;
    }

    public Float getMid() {
        return mid;
    }

    public Float getEnd_T() {
        return end_T;
    }

    public Float getEnd_P() {
        return end_P;
    }

    public Float getAS1() {
        return aS1;
    }

    public void setAS1(Float aS1) {
        this.aS1 = aS1;
    }

    public Float getAS2() {
        return aS2;
    }

    public void setAS2(Float aS1) {
        this.aS1 = aS2;
    }

    public void setTg_number(String tg_number) {
        this.tg_number = tg_number;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public void setMarkId(String markId) {
        this.markId = markId;
    }


    public void setQ1(Float q1) {
        this.q1 = q1;
    }

    public void setQ2(Float q2) {
        this.q2 = q2;
    }

    public void setQ3(Float q3) {
        this.q3 = q3;
    }

    public void setQ4(Float q4) {
        this.q4 = q4;
    }

    public void setMid(Float mid) {
        this.mid = mid;
    }

    public void setEnd_T(Float end_T) {
        this.end_T = end_T;
    }

    public void setEnd_P(Float end_P) {
        this.end_P = end_P;
    }
}
