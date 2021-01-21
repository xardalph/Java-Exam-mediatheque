package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Dvd extends Aempruntable {
    private String genreFilm;
    private String prod;


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
