package traveltimecalculator.views;

import Controller.ControllerWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import traveltimecalculator.model.TravelTimeCalculator;

/**
 * Main frame for travel time calculator.
 *
 * @author Jose
 */
public class MainFrame extends JFrame {

    //constructor
    JMenuBar NavBar;
    public JPanel FormAddRoad, FormResult;
    public JLabel TextRoad, TextSpeed;
    public JComboBox combo2, Combo1;
    public JTextField speed, type;
    public JButton Okbutton;

    public MainFrame() {
        initWindow();
    }

    private void initWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 150);
        setTitle("TIME.SPEED.TRAVEL");
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        //Panel design
        FormAddRoad = new JPanel(new FlowLayout());

        TextRoad = new JLabel("Road : ");
        Combo1 = new JComboBox();

        TextSpeed = new JLabel("Speed : ");
        speed = new JTextField(10);
        for (int i = 0; i < TravelTimeCalculator.speedLimits.size(); i++) {
            Combo1.addItem(TravelTimeCalculator.speedLimits.get(i).getRoad());

            double s = TravelTimeCalculator.speedLimits.get(i).getSpeed();
            System.out.println(s);
            speed.setText(s + "");

        }

//        for (int i = 0; i < TravelTimeCalculator.speedLimits.size(); i++) {
//            
//
//        }
        Okbutton = new JButton("Ok");

        FormAddRoad.add(TextRoad);
        FormAddRoad.add(Combo1);
        FormAddRoad.add(TextSpeed);
        FormAddRoad.add(speed);
        FormAddRoad.add(Okbutton);

        add(FormAddRoad, BorderLayout.CENTER);

        //add it
        NavBarBuild();
        setVisible(true);
    }

    private void NavBarBuild() {
        NavBar = new JMenuBar();
        JMenu NAV;
        JMenuItem mnuItem;
        ControllerWindow controllerWindow = new ControllerWindow(this);

        //Button APP
        NAV = new JMenu("Panel");
        mnuItem = new JMenuItem("AddFrom");
        mnuItem.setActionCommand("AddForm");
        mnuItem.addActionListener(controllerWindow);
        NAV.add(mnuItem);
        mnuItem = new JMenuItem("Calculate TimeSpeed");
        mnuItem.setActionCommand("Calculate");
        mnuItem.addActionListener(controllerWindow);
        NAV.add(mnuItem);
        NavBar.add(NAV);

        NAV = new JMenu("About");
        mnuItem = new JMenuItem("About");
        mnuItem.setActionCommand("About");
        mnuItem.addActionListener(controllerWindow);
        NAV.add(mnuItem);
        NavBar.add(NAV);
        //help menu
        NAV = new JMenu("Exit");
        mnuItem = new JMenuItem("Exit");
        mnuItem.setActionCommand("EXIT");
        mnuItem.addActionListener(controllerWindow);
        NAV.add(mnuItem);
        NavBar.add(NAV);

        setJMenuBar(NavBar);//add menubar to frame
    }
}
