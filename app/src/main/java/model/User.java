package model;

/**
 * Created by Fernando on 2015-05-04.
 */
public class User {

    private long uId;
    private String uName;
    private String uPhone;
    private String uEmail;

    public User() {
    }

    public long getUId() {
        return uId;
    }

    public void setUId(long uId) {
        this.uId = uId;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUPhone() {
        return uPhone;
    }

    public void setUPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getUEmail() {
        return uEmail;
    }

    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Override
    public String toString() {
        return uName;
    }
}
