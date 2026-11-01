package org.example;

public class department {

    private int CId;
    private String CName;
    private String CIName;
    private int CFee;


    public department(int CId, String CName, String CIName, int CFee) {
        this.CId = CId;
        this.CName = CName;
        this.CIName = CIName;
        this.CFee = CFee;
    }

    public int getCId() {
        return CId;
    }

    public void setCId(int CId) {
        this.CId = CId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public int getCFee() {
        return CFee;
    }

    public void setCFee(int CFee) {
        this.CFee = CFee;
    }

    public String getCIName() {
        return CIName;
    }

    public void setCIName(String CIName) {
        this.CIName = CIName;
    }
}
