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
public class pacientes {

    private int idPacient;
    private String nombre;
    private String apellidos;
    private int edad;
    private int idDoctor;

    //Constructor
    public pacientes() {
    }

    public pacientes(int idPacient, String nombre, String apellidos, int edad, int idDoctor) {
        this.idPacient = idPacient;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.idDoctor = idDoctor;
    }

    //Getters and Setters
    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

}
