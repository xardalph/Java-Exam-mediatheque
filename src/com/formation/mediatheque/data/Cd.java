package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

import java.io.Serializable;

public class Cd extends Aempruntable implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        return "Cd{" +
                "borrow=" + borrow +
                ", reference='" + reference + '\'' +
                ", titre='" + titre + '\'' +
                ", genreMusic='" + genreMusic + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}


