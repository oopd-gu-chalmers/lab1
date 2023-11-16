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
        return nrOfDoors;
    }

    @Override
    public double getEnginePower() {
        return enginePower;
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    private void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color clr) {
        color = clr;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public void startEngine() {
        setCurrentSpeed(0.1);
        engineIsRunning = true;
    }

    @Override
    public void stopEngine() {
        setCurrentSpeed(0);
        engineIsRunning = false;
    }

    @Override
    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount must not be less than 0 or greater than 1");
        }
        incrementSpeed(amount, 1);
    }

    @Override
    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount must not be less than 0 or greater than 1");
        }
        decrementSpeed(amount, 1);
    }

    @Override
    public boolean engineIsRunning() {
        return engineIsRunning;
    }
}
