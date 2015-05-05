package com.ftpha.sqltake2.model;

/**
 * Created by Fernando on 2015-05-04.
 */
public class Cat {

    private int cId;
    private String cName;
    private String cFrom;
    private String cTo;
    private String cSMS;
    private String cEmail;
    private boolean cJustMF;
    private boolean cActive;
    private int uId;


    public Cat() {
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCFrom() {
        return cFrom;
    }

    public void setCFrom(String cFrom) {
        this.cFrom = cFrom;
    }

    public String getCTo() {
        return cTo;
    }

    public void setCTo(String cTo) {
        this.cTo = cTo;
    }

    public String getCSMS() {
        return cSMS;
    }

    public void setCSMS(String cSMS) {
        this.cSMS = cSMS;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public boolean isCJustMF() {
        return cJustMF;
    }

    public void setCJustMF(boolean cJustMF) {
        this.cJustMF = cJustMF;
    }

    public boolean isCActive() {
        return cActive;
    }

    public void setCActive(boolean cActive) {
        this.cActive = cActive;
    }

    public int getUId() {
        return uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return cName;
    }
}
