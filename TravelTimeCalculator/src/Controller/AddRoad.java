/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import traveltimecalculator.model.Mapa;
import traveltimecalculator.model.TravelTimeCalculator;
import traveltimecalculator.views.MainFrame;

/**
 *
 * @author Jimen
 */
public class AddRoad implements ActionListener {

    public Mapa modelo;
    public MainFrame vista;

    public AddRoad(Mapa model, MainFrame vista) {
        this.modelo = model;
        this.vista = vista;
        iniciarListener();
    }

    private void iniciarListener() {
        this.vista.Okbutton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vista.Okbutton == evento.getSource()) {

            String type = vista.Combo1.getSelectedItem().toString();
            double distancia = Double.parseDouble(vista.speed.getText());
            for (int i = 0; i < TravelTimeCalculator.speedLimits.size(); i++) {
                if (type.equals(TravelTimeCalculator.speedLimits.get(i).getRoad())) {
                    TravelTimeCalculator.speedLimits.get(i).setSpeed(distancia);
                }
            }

            JOptionPane.showMessageDialog(vista, "Updated Succesfully");

        }

    }
}
