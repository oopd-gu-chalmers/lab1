import java.util.ArrayList;

public class CarModel {
    private ArrayList<Vehicle> cars = new ArrayList<>();

    public CarModel(ArrayList<Vehicle> vehicles) {
        cars = vehicles;
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raisePlatform();
            }
        }
    }

    public void lowerBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerPlatform();
            }
        }
    }

    public void startAllCars() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    public void stopAllCars() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
}