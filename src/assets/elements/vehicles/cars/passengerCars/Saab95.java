package assets.elements.vehicles.cars.passengerCars;

import assets.elements.vehicles.cars.PassengerCar;
import assets.elements.vehicles.engines.TurboEngine;

import java.awt.*;

public final class Saab95 extends PassengerCar {
    /**
     * A Saab95 has:
     * <i><p>
     *
     * <p>Seats: 5</p>
     * <p>Doors: 2</p>
     * <p>Engine: Turbo engine with power 125, and turbo factor 1.3</p>
     * <p>Model Name: Saab95</p>
     * <p>Color: Red</p>
     * <p>Height: 1.5 meter</p>
     * <p>Weight: 1400 kg</p>
     * <p></i>
     */

    private static final TurboEngine turboEngine = new TurboEngine(125, 1.3, 100);
    public Saab95(){
        super(5,2, turboEngine, "Saab95", Color.red, 1.5, 1400);
    }

    /**
     * Turn on the turbo
     */
    public void setTurboOn(){
        turboEngine.setTurboOn();
    }

    /**
     * Turn off the turbo
     */
    public void setTurboOff(){
        turboEngine.setTurboOff();
    }
}
