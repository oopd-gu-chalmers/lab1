package renderEngine;

import assets.elements.vehicles.cars.passengerCars.Saab95;
import assets.elements.vehicles.cars.passengerCars.Volvo240;
import assets.elements.vehicles.cars.trucks.ScaniaL280;

public class Application {
    public static void main(String[] args) {
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new ScaniaL280());
        cc.cars.get(1).setPosition(200, 0);
        cc.cars.get(2).setPosition(400,0);
        cc.frame = new CarView("DrivingSim 1.0", cc);
        cc.startTimer();
    }
}
