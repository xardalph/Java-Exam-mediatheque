package com.formation.mediatheque.abstraite;

import java.io.Serializable;

public abstract class Aempruntable extends commonEntity implements Serializable {
    protected boolean borrow;

    public Aempruntable(String reference, String titre, boolean borrow) {
        super(reference, titre);
        this.borrow = borrow;
    }



    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    public String getBorrow() {
        if (this.borrow){
            return "1";
        }
        return "0";

    }

    @Override
    public String toString() {
        return "Aempruntable{" +
                "borrow=" + borrow +
                ", reference='" + reference + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }
}
