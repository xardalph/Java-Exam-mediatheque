package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Cd extends Aempruntable {
    private String proCD1;
    private String proCD2;

    public String getProCD1() {
        return proCD1;
    }

    public void setProCD1(String proCD1) {
        this.proCD1 = proCD1;
    }

    public String getProCD2() {
        return proCD2;
    }

    public void setProCD2(String proCD2) {
        this.proCD2 = proCD2;
    }
}


