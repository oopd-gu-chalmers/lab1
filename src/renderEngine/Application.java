package renderEngine;

import assets.elements.Element;
import assets.elements.vehicles.cars.passengerCars.Saab95;
import assets.elements.vehicles.cars.passengerCars.Volvo240;
import assets.elements.vehicles.cars.trucks.ScaniaL280;

import java.util.ArrayList;

public class Application {
    // The frame that represents this instance View of the MVC pattern

    public static void main(String[] args) {
        SimulationTimer simulationTimer = new SimulationTimer();
        ArrayList<Element> motorVehicles = new ArrayList<>();
        //TODO
        // - STUPID BOTH HAVE MOTOR VEHICLES
        Controller controller = new Controller(motorVehicles);
        View view = new View("DrivingSim 1.0", controller, motorVehicles);

        simulationTimer.addObserver(controller);
        simulationTimer.addObserver(view);

        motorVehicles.add(new Volvo240());
        motorVehicles.add(new Saab95());
        motorVehicles.add(new ScaniaL280());
        motorVehicles.get(1).setPosition(200, 0);
        motorVehicles.get(2).setPosition(400,0);
        simulationTimer.timer.start();
    }
}
