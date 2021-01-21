package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Livre extends Aempruntable {
    private String proLivre1;
    private String proLivre2;

    public String getProLivre1() {
        return proLivre1;
    }

    public void setProLivre1(String proLivre1) {
        this.proLivre1 = proLivre1;
    }

    public String getProLivre2() {
        return proLivre2;
    }

    public void setProLivre2(String proLivre2) {
        this.proLivre2 = proLivre2;
    }
}
