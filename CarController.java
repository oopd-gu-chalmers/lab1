import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    private ArrayList<Vehicle> cars = new ArrayList<>();

    public CarController(ArrayList<Vehicle> vehicles) {
        cars = vehicles;
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
       for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Vehicle car : cars
                ) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle car : cars
                ) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raisePlatform();
            }
        }
    }

    void lowerBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerPlatform();
            }
        }
    }

    void startAllCars() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
}
