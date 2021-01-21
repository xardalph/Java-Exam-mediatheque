package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.commonEntity;

public class Magazine extends commonEntity {
    private String titre;
    private String role;

    @Override
    public String getTitre() {
        return titre;
    }

    @Override
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
