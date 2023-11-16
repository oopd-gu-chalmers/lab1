package assets.elements.vehicles.cars;

import assets.elements.vehicles.Car;
import assets.elements.vehicles.engines.Engine;

import java.awt.*;

/**
 * A PassengerCar is a Car with a seat count
 */
public abstract class PassengerCar extends Car {
    private final int nrSeats;

    public PassengerCar(int nrSeats, int nrDoors, Engine engine, String modelName, Color color, double height, double weight) {
        super(nrDoors, engine, modelName, color, height, weight);
        this.nrSeats = nrSeats;
    }


    public int getNrSeats(){
        return nrSeats;
    }
}
