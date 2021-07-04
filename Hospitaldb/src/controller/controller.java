/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Dao;
import model.doctores;
import model.pacientes;
import view.view;

/**
 *
 * @author Jimen
 */
public class controller {

    private view view;
    private Dao DAO;

    //Constructor
    public controller(view view) {
        this.view = view;
    }

    public controller(view view, Dao DAO) {
        this.view = view;
        this.DAO = DAO;
    }

    //Getters And Setters 
    public view getView() {
        return view;
    }

    public void setView(view view) {
        this.view = view;
    }

    public Dao getDAO() {
        return DAO;
    }

    public void setDAO(Dao DAO) {
        this.DAO = DAO;
    }

    //METHODS
    /**
     * Choose an option to run
     *
     * @param option
     * @throws SQLException
     */
    public void Controldeflujo(int option) throws SQLException {
        switch (option) {
            case 0://("0.-Salir");
                this.getDAO().CloseConnection();
                break;
            case 1://("1.-Buscar paciente (por su nombre) y mostrar sus datos");
                this.FiltrarpacienteporNombre();
                break;
            case 2://("2.-Añadir paciente al registro");
                this.AddNewPacientToBBDD();
                break;
            case 3:// "3.-Dar de baja un paciente (por id)");
                // this.DeleteMovie();
                break;
            case 4://4.-Mostrar todos los pacientes";
                this.Listarpacientes(this.getDAO().listAll());
                break;
            case 5://"5.-Añadir un doctor";
                this.AddNewDoctorToBBDD();
                break;
            case 6://"6.-Ver todos los doctores (mostrar todos sus datos);
                this.Listardoctores(this.getDAO().listAlldoc());
                break;
            case 7://7.-Ver todos los pacientes de un doctor (por idDoctor);
                break;
            default:
                this.getView().IncorrectOption();
                break;
        }

    }

    /**
     * We use this function to take a name and filter by it
     *
     * @throws SQLException
     */
    public void FiltrarpacienteporNombre() throws SQLException {
        String name = this.getView().IntroduceData("Name:");
        for (pacientes paciente : this.getDAO().byName(name)) {
            this.view.mostrarpacientecompleto(paciente.getIdPacient(), paciente.getNombre(), paciente.getApellidos(), paciente.getEdad(), paciente.getIdDoctor());
        }
    }

    /**
     * This functions allow us to add a new pacient to BBDD
     *
     * @throws SQLException
     */
    public void AddNewPacientToBBDD() throws SQLException {
        String[] PacientToAdd = this.getView().NewPatientForm();
        pacientes paciente = new pacientes(12, "ahjsdghjafg", "asdfasdas", 32, 23);
        //Harcodeo esta parte porque no he conseguido pasar desde la view un int, string string int int , solo un String x6
        //pacientes paciente = new pacientes(PacientToAdd[0], PacientToAdd[1], PacientToAdd[2], PacientToAdd[3], PacientToAdd[4], PacientToAdd[5]);
        if (this.getDAO().createNewPatient(paciente)) {
            System.out.println("Added Successfuly");
        } else {
            System.out.println("SOMETHING WENT WRONG!");
        }
    }

    /**
     * List the complete data received form array took from the bbdd
     *
     * @param pacientesArr
     */
    public void Listarpacientes(ArrayList<pacientes> pacientesArr) {
        for (pacientes paciente : pacientesArr) {
            this.view.mostrarpacientecompleto(paciente.getIdPacient(), paciente.getNombre(), paciente.getApellidos(), paciente.getEdad(), paciente.getIdDoctor());
        }
    }

    /**
     * This functions allow us to add a new pacient to BBDD
     *
     * @throws SQLException
     */
    public void AddNewDoctorToBBDD() throws SQLException {
        String[] DoctorToAdd = this.getView().NewDocForm();
        doctores doctor = new doctores(12, "ahjsdghjafg", "asda");
        //Harcodeo esta parte porque no he conseguido pasar desde la view un int, string string int int , solo un String x6
        //doctores doc = new doctores(DoctorToAdd[0], DoctorToAdd[1], DoctorToAdd[2]);
        if (this.getDAO().createNewDoc(doctor)) {
            System.out.println("Added Successfuly");
        } else {
            System.out.println("SOMETHING WENT WRONG!");
        }
    }

    /**
     * List the complete data received form array took from the bbdd
     *
     * @param doctoresArr
     */
    public void Listardoctores(ArrayList<doctores> doctoresArr) {
        for (doctores doctor : doctoresArr) {
            this.view.mostrardoctorcompleto(doctor.getIdDoctor(), doctor.getNombre(), doctor.getEspecialidad());
        }
    }

}
