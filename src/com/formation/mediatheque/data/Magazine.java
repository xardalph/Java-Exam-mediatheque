package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.commonEntity;

public class Magazine extends commonEntity {
    private String marque;
    private String role;

    public Magazine(String reference, String titre, String marque, String role) {
        super(reference, titre);
        this.marque = marque;
        this.role = role;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}