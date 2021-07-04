/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jimen
 */
public class view {

    /**
     *
     */
    public void printMenu() {

        System.out.println("\t--- CHOOSE AN OPTION: ---");
        System.out.println("0.- EXIT");
        System.out.println("1.- LIST ALL FILMS");
        System.out.println("2.- FILTER BY GENRE");
        System.out.println("3.- ADD FILM");
        System.out.println("4.- MODIFY FILM");
        System.out.println("5.-DELETE FILM");
        System.out.println("");
    }

    /**
     *
     */
    public void IncorrectOption() {
        System.out.println("Choose a correct Option MTFK!!");
    }

    /**
     *
     * @param genero
     */
    public void GenreSelected(String genero) {
        System.out.println("Pelicules de genere: " + genero + ":\n");
    }

    /**
     *
     * @param tittle
     * @param duration
     * @param country
     * @param genre
     * @param age
     * @param valoration
     * @param synopsis
     */
    public void printMovie(String tittle, String duration, String country, String genre, String age, String valoration, String synopsis) {
        StringBuilder sb = new StringBuilder();
        sb.append(tittle).append("  -  ").append(duration).append("  -  ").append(country).append("  -  ").append(genre).append("  -  ").append(age).append("  -  ")
                .append(valoration).append("\n");
        char[] sinop = synopsis.toCharArray();
        for (char c : sinop) {
            if (sb.toString().length() % 150 != 0) {
                sb.append(c);
            } else {
                sb.append("\n").append(c);
            }
        }
        System.out.println(sb.toString() + "\n\n");
    }

    /**
     *
     * @return
     */
    public String[] IntroduceMovie() {
        Scanner intro = new Scanner(System.in);
        intro.useDelimiter("\n");
        System.out.println("Title");
        String tittle = intro.next();
        System.out.println("Duration");
        String duration = intro.next();
        System.out.println("country");
        String country = intro.next();
        System.out.println("genre");
        String genre = intro.next();
        System.out.println("age");
        String age = intro.next();
        System.out.println("valoration");
        String valoration = intro.next();
        System.out.println("synopsis");
        String synopsis = intro.next();
        String[] Movie = {tittle, duration, country, genre, age, valoration, synopsis};
        return Movie;
    }

    /**
     *
     * @param parameter
     * @return
     */
    public String IntroduceData(String parameter) {
        Scanner intro = new Scanner(System.in);
        intro.useDelimiter("\n");
        String data;
        System.out.println("Introduce the  " + parameter + ":");

        try {
            data = intro.next();
        } catch (InputMismatchException e) {
            intro.next();
            data = null;
        }

        return data;
    }
}
