package com.formation.mediatheque.data;

import com.formation.mediatheque.abstraite.Aempruntable;

import java.io.Serializable;

public class Dvd extends Aempruntable implements Serializable {
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

    @Override
    public String toString() {
        return "Dvd{" +
                "borrow=" + borrow +
                ", reference='" + reference + '\'' +
                ", titre='" + titre + '\'' +
                ", genreFilm='" + genreFilm + '\'' +
                ", prod='" + prod + '\'' +
                '}';
    }
}
