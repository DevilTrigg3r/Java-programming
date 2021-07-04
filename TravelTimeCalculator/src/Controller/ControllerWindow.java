/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import traveltimecalculator.model.Mapa;
import traveltimecalculator.views.CalculateForm;
import traveltimecalculator.views.MainFrame;

/**
 *
 * @author Jimen
 */
public class ControllerWindow implements ActionListener {

    MainFrame w;
    JPanel vie;

    public ControllerWindow(MainFrame w) {
        this.w = w;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "Addform":
                System.out.println("action= " + action);
                DisplayAddForm();
                break;
            case "Calculate":
                DisplayCalculateForm();
                break;
            case "About":
                DisplayAbout();
                break;
            case "EXIT":
                displayexit();
                break;
            default:
                //if is not listed, go to the switch n the controller
                //controller.processRequest(action);
                break;
        }
        System.out.println("action= " + action);
    }

    private void DisplayAddForm() {
        Mapa mapped = new Mapa("", 0);
        vie = w.FormAddRoad;
        w.setContentPane(vie);
        w.validate();
        AddRoad c1 = new AddRoad(mapped, w);
    }

    private void DisplayCalculateForm() {
        CalculateForm form = new CalculateForm();
        Mapa mapped = new Mapa("", 0);
        w.setContentPane(form);
        w.validate();
        CalculatorController Cont = new CalculatorController(mapped, form);
    }

    private void DisplayAbout() {
        JOptionPane.showMessageDialog(w, "@Created by UriZ3nCorp ", "", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displayexit() {
        int result = JOptionPane.showConfirmDialog(w, "Are you sure yow want to quit?");
        if (result == JOptionPane.YES_OPTION) {
            // Yes button was pressed
            System.exit(0);
        }
    }
}
