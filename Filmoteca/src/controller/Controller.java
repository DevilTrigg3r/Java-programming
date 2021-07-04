/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DAO;
import model.Film;
import model.Filmoteca;
import view.view;

/**
 *
 * @author Jimen
 */
public class Controller {

    private Filmoteca Filmoteca;
    private view VIEW;
    private DAO DAO;

    /**
     *
     * @param v
     * @param f
     * @throws SQLException
     */
    public Controller(view v, File f) throws SQLException {

        this.VIEW = v;
        this.DAO = new DAO();
        this.Filmoteca = new Filmoteca();

        try {
            this.load(f);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //GETTERS AND SETTERS 
    public Filmoteca getFilmoteca() {
        return Filmoteca;
    }

    public void setFilmoteca(Filmoteca Filmoteca) {
        this.Filmoteca = Filmoteca;
    }

    public view getView() {
        return VIEW;
    }

    public void setView(view vista) {
        this.VIEW = vista;
    }

    public DAO getDAO() {
        return DAO;
    }

    public void setDAO(DAO DAO) {
        this.DAO = DAO;
    }

    //METHODS 
    /**
     * Read the text file and fill the next array to save it
     *
     * @param filmoteca
     * @throws IOException
     */
    public void load(File filmoteca) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fr = new FileReader(filmoteca);
            BufferedReader br = new BufferedReader(fr);

            String head = "Tittle / Duration / Country / Genre / Age / Valoration / Synopsis";
            String line;
            while ((line = br.readLine()) != null) {
                Film FilmBbdd = new Film();

                if (!line.contains(head) && !line.isEmpty()) {
                    String[] pieces = line.split("/");

                    if (pieces.length == 7) {
                        FilmBbdd.setTittle(pieces[0].trim());
                        FilmBbdd.setDuration(pieces[1].trim());
                        FilmBbdd.setCountry(pieces[2].trim());
                        FilmBbdd.setGenre(pieces[3].trim());
                        FilmBbdd.setAge(pieces[4].trim());
                        FilmBbdd.setValoration(pieces[5].trim());
                        FilmBbdd.setSypnosis(pieces[6].trim());
                        //System.out.println(p.toString());
                        this.Filmoteca.addFilm(FilmBbdd);
                    } else {

                        sb.append(line).append("\n");
                    }
                }

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("We got some troubles " + e);
        }
        if (sb != null) {
            System.out.println(sb.toString());
        }
    }

    /**
     * Choose an option to run
     *
     * @param option
     * @throws SQLException
     */
    public void controlDeFluxe(int option) throws SQLException {
        switch (option) {
            case 0:
                this.getDAO().CloseConnection();
                break;
            case 1:
                this.ListAllMovies(this.getDAO().listAll());
                break;
            case 2:
                this.FilterByGenre();
                break;
            case 3:
                this.AddMovie();
                break;
            case 4:
                this.UpdateMovie();
                break;
            case 5:
                this.DeleteMovie();
                break;
            default:
                this.getView().IncorrectOption();
                break;
        }

    }

    /**
     * Print an array from bbdd
     *
     * @param pelis
     */
    public void ListAllMovies(ArrayList<Film> Movies) {
        for (Film Film : Movies) {
            this.VIEW.printMovie(Film.getTittle(), Film.getDuration(), Film.getAge(), Film.getGenre(), Film.getCountry(), Film.getValoration(), Film.getSypnosis());
        }
    }

    /**
     * In this function we are gonna filt by genre
     *
     * @throws SQLException
     */
    public void FilterByGenre() throws SQLException {
       String genre = this.getView().IntroduceData("Genere:");
        for (Film Film : this.getDAO().Bygenre(genre)) {
            this.getView().printMovie(Film.getTittle(), Film.getDuration(),
                    Film.getAge(), Film.getGenre(), Film.getCountry(), Film.getValoration(), Film.getSypnosis());
        }
    }

    /**
     * Add a New movie
     *
     * @throws SQLException
     */
    public void AddMovie() throws SQLException {
        String[] NewMovie = this.getView().IntroduceMovie();
        Film movie = new Film(NewMovie[0], NewMovie[1], NewMovie[2], NewMovie[3], NewMovie[4], NewMovie[5], NewMovie[6]);
        if (this.getDAO().createNewFilm(movie)) {
            System.out.println("Added Successfuly");
        } else {
            System.out.println("SOMETHING WENT WRONG!");
        }
    }

    /**
     * Find a film by name and modify it
     */
    public void UpdateMovie() {
        String tittle = this.getView().IntroduceData("Intoduce Title: ");
        String[] NewMovie = this.getView().IntroduceMovie();
        Film movie = new Film(NewMovie[0], NewMovie[1], NewMovie[2], NewMovie[3], NewMovie[4], NewMovie[5], NewMovie[6]);
        this.getDAO().updateDBFilm(movie, tittle);
    }

    /**
     * Delete film from tittle
     */
    public void DeleteMovie() {
        String title = this.getView().IntroduceData("Introduce title: ");
        try {
            if (this.getDAO().deleteFilm(title)) {
                System.out.println("Successfuly DELETED");
            } else {
                System.out.println("SOMETHING WENT WRONG");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
