package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Cd extends Aempruntable {
    private String genreMusic;
    private String label;

    public Cd(String reference, String titre, boolean borrow, String genreMusic, String label) {
        super(reference, titre, borrow);
        this.genreMusic = genreMusic;
        this.label = label;
    }

    public String getGenreMusic() {
        return genreMusic;
    }

    public void setGenreMusic(String genreMusic) {
        this.genreMusic = genreMusic;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}


