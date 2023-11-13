package assets.elements.vehicles;

import assets.Startable;
import assets.elements.Vehicle;

import java.awt.*;

/**
 * A Car is a Vehicle with a door count and a single Engine
 */
public abstract class Car extends Vehicle implements Startable {
    private final int nrDoors; // Number of doors on the car
    private Engine engine;
    private boolean started;

    /**
     * @param nrDoors number of doors of the car
     * @param engine engine of the car
     * @param modelName the name of the model
     * @param color color of the car, can be changed with {@link #setColor}
     */
    public Car(int nrDoors, Engine engine, String modelName, Color color, double height, double weight){
        super(modelName, color, height, weight);
        this.nrDoors = nrDoors;
        this.engine = engine;
        stop();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public void start(){
        started = true;
        engine.start();
    }
    public void stop(){
        started = false;
        engine.stop();
    }

    public boolean isStarted(){
        return started;
    }

    private void incrementSpeed(double amount){
        double newSpeed = Math.min(getSpeed() + engine.getGeneratedPower() * amount, engine.getEnginePower());
        if (newSpeed > getSpeed()) setSpeed(newSpeed);
    }

    private void decrementSpeed(double amount){
        double newSpeed = Math.max(getSpeed() - engine.getGeneratedPower() * amount,0);
        if (newSpeed < getSpeed()) setSpeed(newSpeed);
    }

    /**
     * The gas method is used to increase the speed of the car
     * @param amount gas amount between 0 and 1
     */
    public void gas(double amount){
        if (!isStarted()){
            System.out.println("Car must be started to use gas!");
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

    public void setEngine(Engine engine){
        this.engine = engine;
    }

    @Override
    public double getWeight() {
        return super.getWeight() + engine.getWeight();
    }
}
