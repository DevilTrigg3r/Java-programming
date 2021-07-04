/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import controller.Controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Film;
import model.Filmoteca;
import view.view;

/**
 *
 * @author Jimen
 */
public class Cinema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        // TODO code application logic here
        Scanner intro = new Scanner(System.in);
        File filmoteca = new File("C:\\Users\\Jimen\\OneDrive\\Documentos\\NetBeansProjects\\Filmoteca\\filmoteca.txt");
        Controller Ctrl = new Controller(new view(), filmoteca);
        cargaEnBD(Ctrl);

        int option = 0;
        do {
            Ctrl.getView().printMenu();
            try {
                option = intro.nextInt();
                Ctrl.controlDeFluxe(option);
            } catch (InputMismatchException e) {
                option = -1;
                intro.next();
                System.out.println("INVALID OPTION, CHOOSE A CORRECT OPTION \n");
            }
        } while (option != 0);
    }

    public static void cargaEnBD(Controller Ctrl) throws SQLException {
        for (Film filmfrombbdd : Ctrl.getFilmoteca().getFilmoteca()) {
            Ctrl.getDAO().createNewFilm(filmfrombbdd);
        }
    }
}
