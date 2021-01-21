package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

public class Dvd extends Aempruntable {
    private String genreFilm;
    private String prod;


    public String getgenreFilm() {
        return genreFilm;
    }

    public void setgenreFilm(String genreFilm) {
        this.genreFilm = genreFilm;
    }

    public String getprod() {
        return prod;
    }

    public void setprod(String prod) {
        this.prod = prod;
    }
}
