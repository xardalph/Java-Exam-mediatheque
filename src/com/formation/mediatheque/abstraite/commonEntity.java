package com.formation.mediatheque.abstraite;

public abstract class commonEntity {
    private String reference;
    public String titre;

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
}
