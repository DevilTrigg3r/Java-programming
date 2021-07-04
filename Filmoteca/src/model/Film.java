/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jimen
 */
public class Film {

    private String tittle;
    private String duration;
    private String country;
    private String genre;
    private String age;
    private String valoration;
    private String sypnosis;

    public Film(String tittle, String duration, String country, String genre, String age, String valoration, String sypnosis) {
        this.tittle = tittle;
        this.duration = duration;
        this.country = country;
        this.genre = genre;
        this.age = age;
        this.valoration = valoration;
        this.sypnosis = sypnosis;
    }

    public Film() {
    }

    //GETTERS AND SETTERS 
    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getValoration() {
        return valoration;
    }

    public void setValoration(String valoration) {
        this.valoration = valoration;
    }

    public String getSypnosis() {
        return sypnosis;
    }

    public void setSypnosis(String sypnosis) {
        this.sypnosis = sypnosis;
    }

    //METHODS
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Film | Tittle: ").append(tittle);
        sb.append(" | Duration: ").append(duration);
        sb.append(" | Country: ").append(country);
        sb.append(" | Genre: ").append(genre);
        sb.append(" | Edad: ").append(age);
        sb.append(" | Valoration: ").append(valoration);
        sb.append(" | Synopsis: ").append(sypnosis);
        return sb.toString();
    }

}
