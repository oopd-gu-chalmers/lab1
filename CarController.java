import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    private CarModel carModel;

    public CarController(ArrayList<Vehicle> model) {
        carModel = model;
    }

    void gas(int amount) {
        carModel.gas(amount);
    }

    void brake(int amount) {
        carModel.brake(amount);
    }

    void turboOn() {
        carModel.turboOn();
    }

    void turboOff() {
        carModel.turboOff();
    }

    void liftBed() {
        carModel.liftBed();
    }

    void lowerBed() {
        carModel.lowerBed();
    }

    void startAllCars() {
        carModel.startAllCars();
    }

    void stopAllCars() {
        carModel.stopAllCars();
    }
}