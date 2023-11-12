package elements.vehicles.passengerCars;

import elements.vehicles.PassengerCar;

import java.awt.*;

public final class Volvo240 extends PassengerCar {

    private static final double trimFactor = 1.25;

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
        super(5, 4, 100, "Volvo240", Color.black);
        stopEngine();
    }

    @Override
    protected double intrinsicSpeedFactor(){
        return trimFactor;
    }
}
