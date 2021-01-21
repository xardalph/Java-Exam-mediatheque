package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Dvd extends Aempruntable {
    private String genreFilm;
    private String prod;

    public Dvd(String reference, String titre, boolean borrow, String genreFilm, String prod) {
        super(reference, titre, borrow);
        this.genreFilm = genreFilm;
        this.prod = prod;
    }

    public String getGenreFilm() {
        return genreFilm;
    }

    public void setGenreFilm(String genreFilm) {
        this.genreFilm = genreFilm;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }
}
