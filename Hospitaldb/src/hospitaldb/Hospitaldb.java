/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitaldb;

import controller.controller;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import view.view;

/**
 *
 * @author Jimen
 */
public class Hospitaldb {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        // TODO code application logic here
        Scanner intro = new Scanner(System.in);
        controller Ctrl = new controller(new view());

        int option = 0;
        do {
            Ctrl.getView().printMenu();
            try {
                option = intro.nextInt();
                Ctrl.Controldeflujo(option);
            } catch (InputMismatchException e) {
                option = -1;
                intro.next();
            }
        } while (option != 0);

    }

}
