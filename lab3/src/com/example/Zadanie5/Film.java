package com.example.Zadanie5;

public class Film {
    String tytul;
    String gatunek;
    String rok;
    long dochod;

    public Film(String tytul, String gatunek, String rok, long dochod) {
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.rok = rok;
        this.dochod = dochod;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public long getDochod() {
        return dochod;
    }

    public void setDochod(long dochod) {
        this.dochod = dochod;
    }
}
