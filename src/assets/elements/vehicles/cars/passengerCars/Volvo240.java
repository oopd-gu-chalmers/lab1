package assets.elements.vehicles.cars.passengerCars;

import assets.elements.vehicles.cars.PassengerCar;
import assets.elements.vehicles.engines.TrimmedEngine;

import java.awt.*;

/**
 * A Volvo240 is a PassengerCar with a TrimmedEngine
 */
public final class Volvo240 extends PassengerCar {

    /**
     * A Volvo240 has:
     * <i><p>
     *
     * <p>Seats: 5</p>
     * <p>Doors: 4</p>
     * <p>Engine: Trimmed engine with trim factor 1.25</p>
     * <p>Model Name: Volvo240</p>
     * <p>Color: Black</p>
     * <p>Height: 1.4 meters</p>
     * <p>Weight: 1300 kg</p>
     *
     * <p></i>
     *
     */
    public Volvo240(){
        super(5, 4, new TrimmedEngine(100, 1.25, 90), "Volvo240", Color.black, 1.4, 1300);
    }

}
