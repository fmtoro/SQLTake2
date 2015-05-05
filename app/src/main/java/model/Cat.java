package model;

/**
 * Created by Fernando on 2015-05-04.
 */
public class Cat {

    private long cId;
    private String cName;
    private String cFrom;
    private String cTo;
    private String cUnit;
    private String cSMS;
    private String cEmail;
    private boolean cJustMF;
    private boolean cActive;
    private long uId;


    public Cat() {
    }

    public long getCId() {
        return cId;
    }

    public void setCId(long cId) {
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

    public String getCUnit() {
        return cUnit;
    }

    public void setCUnit(String cUnit) {
        this.cUnit = cUnit;
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

    public long getUId() {
        return uId;
    }

    public void setUId(long uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return cName;
    }
}
