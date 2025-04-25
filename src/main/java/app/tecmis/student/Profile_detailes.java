package app.tecmis.student;

public class Profile_detailes {
    private String f_name;
    private String l_name;
    private String nic;
    private String bod;
    private String address;
    private String email;

    public Profile_detailes(String f_name, String l_name, String nic, String bod, String address, String email) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.nic = nic;
        this.bod = bod;
        this.address = address;
        this.email = email;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getNic() {
        return nic;
    }

    public String getBod() {
        return bod;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
