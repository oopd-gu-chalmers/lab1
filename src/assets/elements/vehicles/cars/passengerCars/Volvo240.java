package assets.elements.vehicles.cars.passengerCars;

import assets.elements.vehicles.cars.PassengerCar;
import assets.elements.vehicles.engines.TrimmedEngine;

import java.awt.*;

public final class Volvo240 extends PassengerCar {

    /**
     * A Volvo240 has:
     * <i><p>
     *
     * <p>Seats: 5</p>
     * <p>Doors: 4</p>
     * <p>Color: Black</p>
     * <p>Engine Power: 100</p>
     * <p>Model Name: Volvo240</p>
     *
     * <p></i>
     * A Volvo240 has an intrinsic trim factor of 1.25
     */
    public Volvo240(){
        super(5, 4, new TrimmedEngine(100, 1.25, 90), "Volvo240", Color.black, 1.4, 1300);
    }
}
