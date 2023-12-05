package renderEngine;

import assets.elements.ActiveElement;
import assets.elements.Element;
import assets.elements.vehicles.Car;
import assets.elements.vehicles.cars.passengerCars.Saab95;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 **/

public class Controller implements Channel{
    ArrayList<Element> cars = new ArrayList<>();

    @Override
    public void update(){
        //System.out.println("(CAR CONTROLLER) UPDATE IN");
        for (Element car : cars) {
            if (car instanceof ActiveElement) {
                if (car.getPosition()[1] > 500 || car.getPosition()[1] < 0) {
                    double rot = car.getRotation();
                    car.setRotation(180 - rot);
                }

                if (car.getPosition()[0] > 650 || car.getPosition()[0] < 0) {
                    System.out.println(car.getPosition()[0]);
                    double rot = car.getRotation();
                    car.setRotation(0 - rot);
                }
                ((ActiveElement) car).moveTick();
            }
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gasAmount = ((double) amount) / 100;
        for (Element car : cars) {
            if (car instanceof Car) {
                ((Car) car).gas(gasAmount);
            }
        }
    }
    void brake(int amount) {
        double brakeAmount = ((double) amount) / 100;
        for (Element car : cars) {
            if (car instanceof Car){
                ((Car) car).brake(brakeAmount);
            }
        }
    }

    void turboOn() {
        for (Element car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Element car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void start() {
        for (Element car : cars
        ) {
            if (car instanceof Car) {
                ((Car) car).start();
            }
        }
    }

    // ---- CONTROLLER -----

    private JPanel controlPanel = new JPanel();

    private JPanel gasPanel = new JPanel();
    private JSpinner amountSpinner = new JSpinner();
    private int amount = 0;
    private JLabel gasLabel = new JLabel("Gas/Brake #");
    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton extendTrayButton = new JButton("Scania Extend Tray");
    private JButton retractTrayButton = new JButton("Retract Tray");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

    public void addControlPanelToFrame(JFrame frame){
        frame.add(controlPanel);
    }

    public void initControlPanel(JFrame frame) {
        createSpinnerModel();
        createGasPanel();
        createControlPanel(frame);
        createButton(frame, startButton, Color.blue, Color.green);
        createButton(frame, stopButton, Color.red, Color.black);
        addActionListenerToAllButtons();
    }

    private void createControlPanel(JFrame frame) {
        controlPanel.setLayout(new GridLayout(2,5));
        controlPanel.add(gasPanel, 0);
        controlPanel.add(gasButton, 1);
        controlPanel.add(turboOnButton, 2);
        controlPanel.add(extendTrayButton, 3);
        controlPanel.add(startButton, 4);

        controlPanel.add(new JPanel(), 5);
        controlPanel.add(brakeButton, 6);
        controlPanel.add(turboOffButton, 7);
        controlPanel.add(retractTrayButton, 8);
        controlPanel.add(stopButton, 9);

        controlPanel.setPreferredSize(new Dimension((frame.getX())-100, 200));
        controlPanel.setBackground(Color.CYAN);
    }

    private void createButton(JFrame frame, JButton startButton, Color blue, Color green) {
        startButton.setBackground(blue);
        startButton.setForeground(green);
        startButton.setPreferredSize(new Dimension(frame.getX() / 5 - 15, 200));
    }


    private void addActionListenerToAllButtons() {
        //TODO
        // - Can probably make lambda function for it or some shit

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(amount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(amount);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
    }


    private void createGasPanel() {
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(amountSpinner, BorderLayout.PAGE_END);
    }


    private void createSpinnerModel() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        amountSpinner = new JSpinner(spinnerModel);
        amountSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                amount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    }
}
