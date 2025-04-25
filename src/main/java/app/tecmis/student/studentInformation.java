package app.tecmis.student;



public class studentInformation {
    private String f_name;
    private String l_name;
    private String email;

    public studentInformation(String f_name, String l_name, String email) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getEmail() {
        return email;
    }



    public String getstuFullName() {
        return f_name+ " " +l_name;
}
}
