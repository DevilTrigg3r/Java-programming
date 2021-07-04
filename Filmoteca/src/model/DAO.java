/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jimen
 */
public class DAO {

    private String USER = "root";
    private String PSWD = "root";
    private String url = "jdbc:mysql://127.0.0.1/filmoteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection con = null;
    private Statement miStatement = null;
    ResultSet miResultSet = null;

    // CONSTRUCTOR
    /**
     * In this function we are going to establish the connection
     *
     * @throws SQLException
     */
    public DAO() throws SQLException {
        try {
            this.con = DriverManager.getConnection(url, USER, PSWD);
            if (this.con != null) {
                System.out.println("Connection established correctly");
                this.miStatement = this.con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("WE CANNOT GET THE CONNECTION,"
                    + " REASON: ");
            e.printStackTrace();
        }
    }

    // GETTERS Y SETTERS
    public Connection getCon() {
        return con;
    }

    /**
     * Add a new film to the filmoteca
     *
     * @param f
     * @return
     * @throws SQLException
     */
    public boolean createNewFilm(Film f) throws SQLException {
        Boolean flag = false;
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Filmoteca` (`tittle`, `duration`, `country`, `genre`, `age`, `valoration`, `synopsis`) VALUES ('");
        sb.append(f.getTittle()).append("','");
        sb.append(f.getDuration()).append("','");
        sb.append(f.getCountry()).append("','");
        sb.append(f.getGenre()).append("','");
        sb.append(f.getAge()).append("','");
        sb.append(f.getValoration()).append("','");
        sb.append(f.getSypnosis()).append("')");
        try {
            flag = !this.miStatement.execute(sb.toString());
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Delele a film filter by tittle
     *
     * @param f
     * @throws SQLException
     */
    public boolean deleteFilm(String tittle) throws SQLException {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM Filmoteca WHERE tittle='").append(tittle).append("'");
        if (this.miStatement.executeUpdate(sb.toString()) != 0) {
            flag = true;
        }
        System.out.println(flag);
        return flag;
    }

    /**
     * Modify a film from database by tittle
     *
     * @param f
     * @param tittle
     * @return
     */
    public boolean updateDBFilm(Film f, String tittle) {

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Filmoteca SET tittle='");
        sb.append(f.getTittle()).append("', duration ='");
        sb.append(f.getDuration()).append("', country ='");
        sb.append(f.getCountry()).append("', genre ='");
        sb.append(f.getGenre()).append("', age ='");
        sb.append(f.getAge()).append("', valoration ='");
        sb.append(f.getValoration()).append("', sypnosis ='");
        sb.append(f.getSypnosis()).append("' WHERE tittle ='");
        sb.append(tittle).append("'");
        System.out.println(sb.toString());
        try {
            this.miStatement.execute(sb.toString());
            flag = true;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println(flag);
        return flag;
    }

    /**
     * Selec all the films from the bbdd
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Film> listAll() throws SQLException {

        String query = "SELECT * FROM  Filmoteca";
        this.miResultSet = this.miStatement.executeQuery(query);
        ArrayList<Film> movies = new ArrayList<Film>();

        arrayCreation(movies);

        return movies;
    }

    /**
     * Selec all the films form the same genre and list it
     *
     * @param genre
     * @return
     * @throws SQLException
     */
    public ArrayList<Film> Bygenre(String genre) throws SQLException {
        ArrayList<Film> movies = new ArrayList<Film>();

        if (genre != null) {
            String query = "SELECT * FROM  Filmoteca WHERE genre ='" + genre + "'";
            this.miResultSet = this.miStatement.executeQuery(query);

            arrayCreation(movies);
        }
        return movies;
    }

    /**
     * Return a new array
     *
     * @param film
     * @throws SQLException
     */
    public void arrayCreation(ArrayList<Film> Filmoteca) throws SQLException {
        Film f;
        while (this.miResultSet.next()) {
            f = new Film();
            f.setTittle(this.miResultSet.getString("tittle"));
            f.setDuration(this.miResultSet.getString("duration"));
            f.setCountry(this.miResultSet.getString("country"));
            f.setGenre(this.miResultSet.getString("genre"));
            f.setAge(this.miResultSet.getString("age"));
            f.setValoration(this.miResultSet.getString("valoration"));
            f.setSypnosis(this.miResultSet.getString("synopsis"));
            Filmoteca.add(f);
        }
    }

    /**
     * Method to close the connection
     */
    public void CloseConnection() throws SQLException {
        this.getCon().close();
    }
}
