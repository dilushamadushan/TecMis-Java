package app.tecmis.lecture;

public class Medical_Information {

    private String  medical_tg;
    private String  medical_description;
    private String  medical_start_date;
    private String  medical_end_date;
    private String  medical_course;

    public Medical_Information(String medical_course, String medical_end_date, String medical_start_date, String medical_description, String medical_tg) {
        this.medical_course = medical_course;
        this.medical_end_date = medical_end_date;
        this.medical_start_date = medical_start_date;
        this.medical_description = medical_description;
        this.medical_tg = medical_tg;
    }

    public String getMedical_tg() {
        return medical_tg;
    }

    public String getMedical_course() {
        return medical_course;
    }

    public String getMedical_end_date() {
        return medical_end_date;
    }

    public String getMedical_start_date() {
        return medical_start_date;
    }

    public String getMedical_description() {
        return medical_description;
    }
}
