/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Jimen
 */
public class Filmoteca {

    private ArrayList<Film> Filmoteca = new ArrayList<Film>();

    public Filmoteca(ArrayList<Film> Films) {
        this.Filmoteca = Films;
    }

    public Filmoteca() {
    }

    // GETTERS AND SETTERS
    public ArrayList<Film> getFilmoteca() {
        return Filmoteca;
    }

    public void setFilmoteca(ArrayList<Film> Filmoteca) {
        this.Filmoteca = Filmoteca;
    }

    //METHODS
    public void addFilm(Film FilmfromBbdd) {
        this.Filmoteca.add(FilmfromBbdd);
    }
}
