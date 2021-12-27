package com.md.manavfb;

public class sepet {
    private String urun;
    private int miktar;
    private int tutar;

    public sepet() {
    }

    public sepet(String urun, int miktar, int tutar) {
        this.urun = urun;
        this.miktar = miktar;
        this.tutar = tutar;
    }

    public static int miktar() {
        return 0;
    }

    public String getUrun() {
        return urun;
    }

    public void setUrun(String urun) {
        this.urun = urun;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }
}
