package com.md.manavfb;

    public class urunler {
    private  String urunkey;
    private  String urunadi;
    private  int fiyat;
    private  int stok;

    public urunler() {
    }

    public urunler(String urunkey, String urunadi, int fiyat, int stok) {
        this.urunkey = urunkey;
        this.urunadi = urunadi;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public String getUrunkey() {
        return urunkey;
    }

    public void setUrunkey(String urunkey) {
        this.urunkey = urunkey;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
