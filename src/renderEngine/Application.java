package renderEngine;

import assets.elements.vehicles.cars.passengerCars.Saab95;
import assets.elements.vehicles.cars.passengerCars.Volvo240;
import assets.elements.vehicles.cars.trucks.ScaniaL280;

public class Application {
    // The frame that represents this instance View of the MVC pattern

    public static void main(String[] args) {
        SimulationTimer simulationTimer = new SimulationTimer();

        Controller controller = new Controller();
        View view = new View("DrivingSim 1.0", controller);

        simulationTimer.addObserver(controller);
        simulationTimer.addObserver(view);

        controller.cars.add(new Volvo240());
        controller.cars.add(new Saab95());
        controller.cars.add(new ScaniaL280());
        controller.cars.get(1).setPosition(200, 0);
        controller.cars.get(2).setPosition(400,0);
        simulationTimer.timer.start();
    }
}
