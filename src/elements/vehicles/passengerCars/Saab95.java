package elements.vehicles.passengerCars;

import elements.vehicles.PassengerCar;

import java.awt.*;

public final class Saab95 extends PassengerCar {
    private boolean turboOn;
    private static final double turboFactor = 1.3;

    /**
     * A Saab95 has:
     * <i><p>
     *
     * <p>Seats: 5</p>
     * <p>Doors: 2</p>
     * <p>Color: Red</p>
     * <p>Engine Power: 125</p>
     * <p>Model Name: Saab95</p>
     *
     * <p></i>
     * A Saab95 has a turbo which can be toggled with {@link #setTurboOn} and {@link #setTurboOff}
     */
    public Saab95(){
        super(5,2, 125, "Saab95", Color.red);
        setTurboOff();
    }

    /**
     * Turns on the turbo
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns off the turbo
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected double intrinsicSpeedFactor(){
        double turbo = 1;
        if(turboOn) turbo = turboFactor;
        return turbo;
    }
}
