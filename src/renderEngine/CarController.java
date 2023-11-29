package renderEngine;

import assets.elements.ActiveElement;
import assets.elements.Element;
import assets.elements.vehicles.Car;
import assets.elements.vehicles.cars.passengerCars.Saab95;
import assets.elements.vehicles.cars.passengerCars.Volvo240;
import assets.elements.vehicles.cars.trucks.ScaniaL280;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 **/

public class CarController {

    // 20 updates per second = 50ms
    private final int delay = 50;

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    ArrayList<Element> cars = new ArrayList<>();

    public static void main(String[] args) {
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new ScaniaL280());
        cc.cars.get(1).setPosition(200, 0);
        cc.cars.get(2).setPosition(400,0);
        cc.frame = new CarView("DrivingSim 1.0", cc);
        cc.timer.start();
    }

    /** Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    **/
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
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

                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gasAmount = ((double) amount) / 100;
        for (Element car : cars) {
            if (car instanceof Car) {
                ((Car) car).gas(gasAmount);
                ((Car) car).turnLeft(2);
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
}
