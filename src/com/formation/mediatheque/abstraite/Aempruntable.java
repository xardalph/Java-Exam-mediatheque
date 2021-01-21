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


}
