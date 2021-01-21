package com.formation.mediatheque.abstraite;

public abstract class Aempruntable extends commonEntity {
    private boolean borrow;

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }
}
