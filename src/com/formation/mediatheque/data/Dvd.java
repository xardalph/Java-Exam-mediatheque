package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Dvd extends Aempruntable {
    private String proDVD1;
    private String proDVD2;


    public String getProDVD1() {
        return proDVD1;
    }

    public void setProDVD1(String proDVD1) {
        this.proDVD1 = proDVD1;
    }

    public String getProDVD2() {
        return proDVD2;
    }

    public void setProDVD2(String proDVD2) {
        this.proDVD2 = proDVD2;
    }
}
