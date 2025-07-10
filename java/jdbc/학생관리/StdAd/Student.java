package sec01.StdAd;

public class Student {
    private int stdno;
    private String stdname;
    private String phone;
    private String email;
    public Student(int stdno, String stdname, String phone,String email) {
        super();
        this.stdno = stdno;
        this.stdname= stdname;
        this.phone = phone;
        this.email=email;
    }

    public int getStdno() {
        return stdno;
    }

    public String getStdname() {
        return stdname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setStdno(int stdno) {
        this.stdno = stdno;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student [stdno=" + stdno + ", stdname=" + stdname + ",Phone="+phone+", email="+email+"]";
    }
}