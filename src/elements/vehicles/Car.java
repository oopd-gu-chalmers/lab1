package elements.vehicles;

import elements.Vehicle;

import java.awt.*;

/**
 * The Car class is the superclass of all cars and trucks
 * A car has:
 * <p>A door count</p>
 * <p>An engine which is ON or OFF, with specific engine power</p>
 * <p>A speed factor which may be intrinsic to each car</p>
 * <p>Any properties of {@link #Vehicle}</>
 */
public abstract class Car extends Vehicle {
    private final int nrDoors; // Number of doors on the car
    private boolean engineOn;
    private final double enginePower; // Engine power of the car

    /**
     * @param nrDoors number of doors of the car
     * @param enginePower engine power of the car, a higher power increases acceleration and max speed
     * @param modelName the name of the model
     * @param color color of the car, can be changed with {@link #setColor}
     */
    public Car(int nrDoors, double enginePower, String modelName, Color color){
        super(modelName, color);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
    }

    /**
     *
     * @param nrDoors number of doors of the car
     * @param enginePower engine power of the car, a higher power increases acceleration and max speed
     * @param modelName the name of the model
     * @param color color of the car, can be changed with {@link #setColor}
     * @param position the x,y position of the car
     * @param rotation the rotation of the car in degrees
     */
    public Car(int nrDoors, double enginePower, String modelName, Color color, double[] position, double rotation){
        super(modelName, color, position, rotation);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    /**
     * Starts the engine, the car will start moving, and it will be possible to use {@link #gas} and {@link #brake}
     */
    public void startEngine(){
        if (isEngineOn()) {
            System.out.println("Engine is already ON");
            return;
        }
        setSpeed(0.1);
        engineOn = true;
    }

    public void stopEngine(){
        if (!engineOn) {
            System.out.println("Engine is already OFF");
            return;
        }
        engineOn = false;
        setSpeed(0);
    }

    /**
     * An intrinsic speed factor for a car, which factors in when the car accelerates or decelerates
     * If a car has an intrinsic speed factor, this method should be overridden in its class
     * @return the intrinsic speed factor
     */
    protected double intrinsicSpeedFactor(){
        return 1;
    }

    private double speedFactor(){
        return enginePower * 0.01 * intrinsicSpeedFactor();
    }

    private void incrementSpeed(double amount){
        double newSpeed = Math.min(getSpeed() + speedFactor() * amount, getEnginePower());
        if (newSpeed > getSpeed()) setSpeed(newSpeed);
    }

    private void decrementSpeed(double amount){
        double newSpeed = Math.max(getSpeed() - speedFactor() * amount,0);
        if (newSpeed < getSpeed()) setSpeed(newSpeed);
    }

    /**
     * The gas method is used to increase the speed of the car
     * @param amount gas amount between 0 and 1
     */
    public void gas(double amount){
        if (!engineOn){
            System.out.println("Engine must be ON to use gas");
            return;
        }
        if (amount < 0 || amount > 1) {
            System.out.println("Gas amount must be double in range [0,1]");
            return;
        }
        incrementSpeed(amount);
    }

    /**
     * The brake method is used to decrease the speed of the car
     * @param amount gas amount between 0 and 1
     */
    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            System.out.println("Brake amount must be double in range [0,1]");
            return;
        }
        decrementSpeed(amount);
    }
}
