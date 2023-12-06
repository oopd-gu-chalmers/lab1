package renderEngine;

import assets.elements.ActiveElement;
import assets.elements.Element;
import assets.elements.vehicles.motorVehicles;
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

public class Controller implements ModelObserver {
    ArrayList<Element> motorVehicles;

    // ---- CONTROLLER UI -----

    private ControllerUI UI = new ControllerUI();

    public Controller(ArrayList<Element> motorVehicles) {
        this.motorVehicles = motorVehicles;
    }

    @Override
    public void update(){
        //System.out.println("(CAR CONTROLLER) UPDATE IN");
        for (Element motorVehicle : motorVehicles) {
            if (motorVehicle instanceof ActiveElement) {
                if (motorVehicle.getPosition()[1] > 500 || motorVehicle.getPosition()[1] < 0) {
                    double rot = motorVehicle.getRotation();
                    motorVehicle.setRotation(180 - rot);
                }

                if (motorVehicle.getPosition()[0] > 650 || motorVehicle.getPosition()[0] < 0) {
                    System.out.println(motorVehicle.getPosition()[0]);
                    double rot = motorVehicle.getRotation();
                    motorVehicle.setRotation(0 - rot);
                }
                ((ActiveElement) motorVehicle).moveTick();
            }
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gasAmount = ((double) amount) / 100;
        for (Element motorVehicle : motorVehicles) {
            if (motorVehicle instanceof motorVehicles) {
                ((motorVehicles) motorVehicle).gas(gasAmount);
            }
        }
    }
    void brake(int amount) {
        double brakeAmount = ((double) amount) / 100;
        for (Element motorVehicle : motorVehicles) {
            if (motorVehicle instanceof motorVehicles){
                ((motorVehicles) motorVehicle).brake(brakeAmount);
            }
        }
    }

    void turboOn() {
        for (Element motorVehicle : motorVehicles){
            if (motorVehicle instanceof Saab95){
                ((Saab95) motorVehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Element motorVehicle : motorVehicles){
            if (motorVehicle instanceof Saab95){
                ((Saab95) motorVehicle).setTurboOff();
            }
        }
    }

    void start() {
        for (Element motorVehicle : motorVehicles
        ) {
            if (motorVehicle instanceof motorVehicles) {
                ((motorVehicles) motorVehicle).start();
            }
        }
    }

    // -- CONTROLLER UI --

    public void addControlPanelToFrame(JFrame frame){
        UI.initUI(frame, this);
        frame.add(UI);
    }
}
