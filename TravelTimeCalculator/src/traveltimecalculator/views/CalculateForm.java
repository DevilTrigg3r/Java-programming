/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveltimecalculator.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import traveltimecalculator.model.TravelTimeCalculator;

/**
 *
 * @author Jimen
 */
public class CalculateForm extends JPanel {

    public JPanel Formcalculate, FormResult;
    public JLabel TextDistance, TextRoad, TimeTravel, TIME;
    public JComboBox combotype;
    public JTextField distance, type;
    public JButton Calculate;

    public CalculateForm() {

        setLayout(new BorderLayout());

        //Panel design
        Formcalculate = new JPanel(new FlowLayout());

        TextDistance = new JLabel("Distance : ");
        distance = new JTextField(10);

        TextRoad = new JLabel("Road : ");
        combotype = new JComboBox();
        for (int i = 0; i < TravelTimeCalculator.speedLimits.size(); i++) {
            combotype.addItem(TravelTimeCalculator.speedLimits.get(i).getRoad());
        }
        Calculate = new JButton("Calculate");

        Formcalculate.add(TextDistance);
        Formcalculate.add(distance);
        Formcalculate.add(TextRoad);
        Formcalculate.add(combotype);
        Formcalculate.add(Calculate);

        //Result panel
        FormResult = new JPanel();
        FormResult.setLayout(new FlowLayout());

        TimeTravel = new JLabel("TimeTravel : ");
        TIME = new JLabel();

        FormResult.add(TimeTravel);
        FormResult.add(TIME);

        add(Formcalculate, BorderLayout.CENTER);
        add(FormResult, BorderLayout.SOUTH);
    }
}
