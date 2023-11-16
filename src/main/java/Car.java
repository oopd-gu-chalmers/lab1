import java.awt.*;

public class Car implements ICar {
    private Color color;
    private int nrOfDoors;
    private double enginePower;
    private double currentSpeed;
    private String modelName;
    private boolean engineIsRunning;

    public Car(Color color, int nrOfDoors, double enginePower, String modelName) {
        this.color = color;
        this.nrOfDoors = nrOfDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
    }

    @Override
    public int getNrDoors() {
        return 0;
    }

    @Override
    public double getEnginePower() {
        return 0;
    }

    @Override
    public double getCurrentSpeed() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void setColor(Color clr) {

    }

    @Override
    public String getModelName() {
        return null;
    }

    @Override
    public void startEngine() {

    }

    @Override
    public void stopEngine() {

    }

    @Override
    public void gas(double amount) {

    }

    @Override
    public void brake(double amount) {

    }

    @Override
    public boolean engineIsRunning() {
        return false;
    }
}
