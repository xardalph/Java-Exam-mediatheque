package com.formation.mediatheque.abstraite;

import java.io.Serializable;

public abstract class commonEntity implements Serializable {
    protected String reference;
    protected String titre;

    public commonEntity(String reference, String titre) {
        this.reference = reference;
        this.titre = titre;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "commonEntity{" +
                "reference='" + reference + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }
}
