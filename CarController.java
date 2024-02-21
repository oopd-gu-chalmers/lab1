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
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Vehicle> cars = new ArrayList<>();
    static Garage<Volvo240> garage;

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(0, 100));
        Scania scania = new Scania();
        scania.setPosition(new Point(0, 200));
        garage = new Garage<>(10, new Point(300, 0));

        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }


    // Calls the gas method for each car once
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
