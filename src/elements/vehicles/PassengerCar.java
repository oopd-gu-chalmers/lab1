package elements.vehicles;

import java.awt.*;

/**
 * A PassengerCar is a Car with a seat count
 */
public abstract class PassengerCar extends Car {
    private final int nrSeats;

    public PassengerCar(int nrSeats, int nrDoors, int enginePower, String modelName, Color color) {
        super(nrDoors, enginePower, modelName, color);
        this.nrSeats = nrSeats;
    }


    public int getNrSeats(){
        return nrSeats;
    }
}
