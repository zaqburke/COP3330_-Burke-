package p5;

public class ContactItem {
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    public ContactItem(String userfirstname, String userlastname, String userphonenumber, String useremail) {
        this.firstname = userfirstname;
        this.lastname = userlastname;
        this.phonenumber = userphonenumber;
        this.email = useremail;
    }
    public void setfirstname(String firstname)
    {
        this.firstname = firstname;
    }
    public String getfirstname()
    {
        return firstname;
    }
    public void setlastname(String lastname)
    {
        this.lastname = lastname;
    }
    public String getlastname()
    {
        return lastname;
    }
    public void setphonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }
    public String getphonenumber()
    {
        return phonenumber;
    }
    public void setemail(String email)
    {
        this.email = email;
    }
    public String getemail()
    {
        return email;
    }
    public String toString()
    {
        return firstname + " " + lastname + ": " + phonenumber + " " + email;
    }
    public String toStringFile()
    {
        return firstname + "\n" + lastname + "\n" + "" + phonenumber + "\n" + email;
    }
}


