package com.formation.mediatheque.abstraite;

public abstract class Aempruntable extends commonEntity {
    public Aempruntable(String reference, String titre, boolean borrow) {
        super(reference, titre);
        this.borrow = borrow;
    }

    private boolean borrow;

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }
}
