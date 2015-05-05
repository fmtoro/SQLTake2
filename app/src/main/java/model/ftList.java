package model;

/**
 * Created by Fernando on 2015-05-04.
 * Originally created as part of: SQLTake2
 * You will love this code and be awed by it's magnificence
 */
public class ftList {



    private int         lId;
    private String      lName;
    private String      lText;
    private int         cId;

    public ftList() {
    }

    public int getLId() {
        return lId;
    }

    public void setLId(int lId) {
        this.lId = lId;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLText() {
        return lText;
    }

    public void setLText(String lText) {
        this.lText = lText;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return lName;
    }
}
