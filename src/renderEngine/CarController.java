package renderEngine;

import assets.elements.ActiveElement;
import assets.elements.Element;
import assets.elements.vehicles.Car;
import assets.elements.vehicles.cars.passengerCars.Saab95;

import java.util.ArrayList;

/**
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 **/

public class CarController implements Channel{
    ArrayList<Element> cars = new ArrayList<>();

    @Override
    public void update(){
        //System.out.println("(CARCONTROLLER) UPDATE IN");
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
}
