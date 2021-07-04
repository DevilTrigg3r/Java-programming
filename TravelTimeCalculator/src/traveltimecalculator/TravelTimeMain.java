/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveltimecalculator;

import Controller.ControllerWindow;
import traveltimecalculator.model.TravelTimeCalculator;
import traveltimecalculator.views.MainFrame;

/**
 *
 * @author mati
 */
public class TravelTimeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        TravelTimeCalculator ArrayFuel = new TravelTimeCalculator();
        MainFrame window = new MainFrame();
        ControllerWindow controller = new ControllerWindow(window);

    }

}
