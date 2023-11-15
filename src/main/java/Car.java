import java.awt.*;

public class Car implements ICar {
    private Color color;
    private int nrOfDoors;
    private double enginePower;
    private double currentSpeed;
    private String modelName;
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
}
