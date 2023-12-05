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
        ArrayList<Element> cars = new ArrayList<>();

        Controller controller = new Controller(cars);
        View view = new View("DrivingSim 1.0", controller);

        simulationTimer.addObserver(controller);
        simulationTimer.addObserver(view);

        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new ScaniaL280());
        cars.get(1).setPosition(200, 0);
        cars.get(2).setPosition(400,0);
        simulationTimer.timer.start();
    }
}
