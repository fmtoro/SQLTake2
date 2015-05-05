package com.ftpha.sqltake2.model;

/**
 * Created by Fernando on 2015-05-04.
 */
public class User {

    private int uId;
    private String uName;
    private String uPhone;
    private String uEmail;

    public User() {
    }

    public int getUId() {
        return uId;
    }

    public void setUId(int uId) {
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
