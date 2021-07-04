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
     * This function display the menu.
     */
    public void printMenu() {
        System.out.println("\t--- WELCOME TO PROVEN HOSPITAL ---");
        System.out.println("0.-Salir");
        System.out.println("1.-Buscar paciente (por su nombre) y mostrar sus datos");
        System.out.println("2.-Añadir paciente al registro");
        System.out.println("3.-Dar de baja un paciente (por id)");
        System.out.println("4.-Mostrar todos los pacientes");
        System.out.println("5.-Añadir un doctor");
        System.out.println("6.-Ver todos los doctores (mostrar todos sus datos)");
        System.out.println("7.-Ver todos los pacientes de un doctor (por idDoctor)");
        System.out.println("");
    }

    /**
     * This function display a function when the users choose a wrong option
     */
    public void IncorrectOption() {
        System.out.println("La opción escogida no es valida.\n Escoga una opción valida.");
    }

    /**
     * This function allow us to display the information from a patient
     *
     * @param idPacient
     * @param nombre
     * @param apellidos
     * @param edad
     * @param idDoctor
     */
    public void mostrarpacientecompleto(int idPacient, String nombre, String apellidos, int edad, int idDoctor) {
        StringBuilder sb = new StringBuilder();
        sb.append(idPacient).append("  -  ").append(nombre).append("  -  ").append(apellidos).append("  -  ").append(edad).append("  -  ").append(idDoctor);
        System.out.println(sb.toString() + "\n\n");
    }

    /**
     *
     * @param idDoctor
     * @param nombre
     * @param especialidad
     */
    public void mostrardoctorcompleto(int idDoctor, String nombre, String especialidad) {
        StringBuilder sb = new StringBuilder();
        sb.append(idDoctor).append("  -  ").append(nombre).append("  -  ").append(especialidad);
        System.out.println(sb.toString() + "\n\n");
    }

    /**
     * Display a little Menu to add a new patient
     *
     * @return
     */
    public String[] NewPatientForm() {
        Scanner intro = new Scanner(System.in);
        intro.useDelimiter("\n");
        System.out.println("idPacient");
        String idPacient = intro.next();
        System.out.println("Nombre");
        String nombre = intro.next();
        System.out.println("Apellidos");
        String apellidos = intro.next();
        System.out.println("Edad");
        String edad = intro.next();
        System.out.println("IdDoctor");
        String idDoctor = intro.next();
        String[] PatientReadyToAdd = {idPacient, nombre, apellidos, edad, idDoctor};
        return PatientReadyToAdd;
    }

    /**
     * Display a little Menu to add a new patient
     *
     * @return
     */
    public String[] NewDocForm() {
        Scanner intro = new Scanner(System.in);
        intro.useDelimiter("\n");
        System.out.println("idDoctor");
        String idDoctor = intro.next();
        System.out.println("Nombre");
        String nombre = intro.next();
        System.out.println("Especialidad");
        String especialidad = intro.next();
        String[] DocReadyToAdd = {idDoctor, nombre, especialidad};
        return DocReadyToAdd;
    }

    /**
     * We use this function to display information to the view and takes the
     * parameter that we need
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
