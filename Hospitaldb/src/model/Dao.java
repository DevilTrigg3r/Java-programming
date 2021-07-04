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
public class Dao {

    private String USER = "";
    private String PSWD = "";
    private String url = "jdbc:mysql://127.0.0.1/Hospitaldb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection con = null;
    private Statement miStatement = null;
    ResultSet miResultSet = null;

    // CONSTRUCTOR
    /**
     * In this function we are going to establish the connection
     *
     * @throws SQLException
     */
    public Dao() throws SQLException {
        try {
            this.con = DriverManager.getConnection(url, USER, PSWD);
            if (this.con != null) {
                System.out.println("Connection established correctly");
                this.miStatement = this.con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("WE CANNOT GET THE CONNECTION,"
                    + " REASON: ");
        }
    }

    /**
     * Connection with
     *
     * @return
     */
    public Connection getCon() {
        return con;
    }

    /**
     * Selec all the pacient from the bbdd
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<pacientes> listAll() throws SQLException {
        String query = "SELECT * FROM pacientes";
        this.miResultSet = this.miStatement.executeQuery(query);
        ArrayList<pacientes> pacientes = new ArrayList<pacientes>();
        arrayCreation(pacientes);
        return pacientes;
    }

    /**
     * Selec all the doctor from the bbdd
     *
     * @return @throws SQLException
     */
    public ArrayList<doctores> listAlldoc() throws SQLException {
        String query = "SELECT * FROM doctores";
        this.miResultSet = this.miStatement.executeQuery(query);
        ArrayList<doctores> DocArray = new ArrayList<doctores>();
        arrayCreationdoc(DocArray);
        return DocArray;
    }

    /**
     * Return a new array for patient
     *
     * @param pacientes
     * @throws SQLException
     */
    public void arrayCreation(ArrayList<pacientes> pacientes) throws SQLException {
        pacientes NewPatient;
        while (this.miResultSet.next()) {
            NewPatient = new pacientes();
            NewPatient.setIdPacient(this.miResultSet.getInt("idPacient"));
            NewPatient.setNombre(this.miResultSet.getString("nombre"));
            NewPatient.setApellidos(this.miResultSet.getString("apellidos"));
            NewPatient.setEdad(this.miResultSet.getInt("edad"));
            NewPatient.setIdDoctor(this.miResultSet.getInt("idDoctor"));
            pacientes.add(NewPatient);
        }
    }

    /**
     * Return a new array for doctores
     *
     * @param DocArray
     */
    private void arrayCreationdoc(ArrayList<doctores> DocArray) throws SQLException {
        doctores NewDoc;
        while (this.miResultSet.next()) {
            NewDoc = new doctores();
            NewDoc.setIdDoctor(this.miResultSet.getInt("idDoctor"));
            NewDoc.setNombre(this.miResultSet.getString("nombre"));
            NewDoc.setEspecialidad(this.miResultSet.getString("especialidad"));
            DocArray.add(NewDoc);
        }
    }

    /**
     * This function allow us to insert a new patient
     *
     * @param NewPatient
     * @return
     * @throws SQLException
     */
    public boolean createNewPatient(pacientes NewPatient) throws SQLException {
        Boolean flag = false;
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `pacientes` (`idPacient`, `nombre`, `apellidos`, `edad`, `idDoctor`) VALUES ('");
        sb.append(NewPatient.getIdPacient()).append("','");
        sb.append(NewPatient.getNombre()).append("','");
        sb.append(NewPatient.getApellidos()).append("','");
        sb.append(NewPatient.getEdad()).append("','");
        sb.append(NewPatient.getIdDoctor()).append("')");
        try {
            flag = !this.miStatement.execute(sb.toString());
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This function allow us to insert a new patient
     *
     * @param DocPatient
     * @return
     * @throws SQLException
     */
    public boolean createNewDoc(doctores DocPatient) throws SQLException {
        Boolean flag = false;
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `doctores` (`idDoctor`, `nombre`, `especialidad`) VALUES ('");
        sb.append(DocPatient.getIdDoctor()).append("','");
        sb.append(DocPatient.getNombre()).append("','");
        sb.append(DocPatient.getEspecialidad()).append("','");
        try {
            flag = !this.miStatement.execute(sb.toString());
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Selec all the films form the same genre and list it
     *
     * @param genre
     * @return
     * @throws SQLException
     */
    public ArrayList<pacientes> byName(String name) throws SQLException {
        ArrayList<pacientes> PacientesArr = new ArrayList<pacientes>();
        if (name != null) {
            String query = "SELECT * FROM  pacientes WHERE name ='" + name + "'";
            this.miResultSet = this.miStatement.executeQuery(query);
            arrayCreation(PacientesArr);
        }
        return PacientesArr;
    }

    /**
     * Method to close the connection
     */
    public void CloseConnection() throws SQLException {
        this.getCon().close();
    }

}
