package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Cd extends Aempruntable {
    private String genreMusic;
    private String label;

    public String getgenreMusic() {
        return genreMusic;
    }

    public void setgenreMusic(String genreMusic) {
        this.genreMusic = genreMusic;
    }

    public String label() {
        return label;
    }

    public void label(String proCD2) {
        this.label = label;
    }
}


