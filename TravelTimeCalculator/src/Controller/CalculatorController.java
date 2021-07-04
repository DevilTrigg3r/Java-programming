/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import traveltimecalculator.model.TravelTimeCalculator;
import traveltimecalculator.views.CalculateForm;
import traveltimecalculator.model.Mapa;

/**
 *
 * @author Jimen
 */
public class CalculatorController implements ActionListener {

    public Mapa modelo;
    public CalculateForm vista;

    public CalculatorController(Mapa model, CalculateForm vista) {
        this.modelo = model;
        this.vista = vista;
        iniciarListener();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vista.Calculate == evento.getSource()) {
            CalculateTime();
        }
    }

    private void iniciarListener() {
        this.vista.Calculate.addActionListener(this);
    }

    private void CalculateTime() {
        double result;
        try {

            double distancia = Double.parseDouble(vista.distance.getText());
            String type = vista.combotype.getSelectedItem().toString();

            for (int i = 0; i < TravelTimeCalculator.speedLimits.size(); i++) {
                if (type.equals(TravelTimeCalculator.speedLimits.get(i).getRoad())) {
                    this.modelo = TravelTimeCalculator.speedLimits.get(i);
                }
            }
            System.out.println(this.modelo.getSpeed());
            result = TravelTimeCalculator.CalculateSpeed(distancia, this.modelo.getSpeed());

            vista.TIME.setText(result + "");

        } catch (NumberFormatException e) {

        }
    }

//    private void CalculateKilometers() {
//        double consume = 0;
//        double €total = 0;
//        double calculate€km = 0;
//        //miramos si la cantidad escrita es correcta
//        try {
//
//            double distancia = Double.parseDouble(vista.distance.getText());
//            double amount = Double.parseDouble(vista.amount.getText());
//            String type = vista.combotype.getSelectedItem().toString();
//
//            for (int i = 0; i < Gasolinera.ArrayFuel.size(); i++) {
//                if (type.equals(Gasolinera.ArrayFuel.get(i).getTipo())) {
//                    this.modelo = Gasolinera.ArrayFuel.get(i);
//                }
//            }
//            System.out.println(this.modelo.getPrice());
//            consume = Gasolinera.CalculateConsumo(distancia, amount);
//            €total = Gasolinera.€total(amount, this.modelo.getPrice());
//            calculate€km = Gasolinera.Calculate€Km(distancia, this.modelo.getPrice());
//
//            vista.lbconsumo.setText(consume + "");
//            vista.lb€.setText(€total + "");
//            vista.lb€km.setText(calculate€km + "");
//
//        } catch (NumberFormatException e) {
//            // vista.lbText.setText("Error");
//        }
//    }
}
