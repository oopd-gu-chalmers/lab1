import java.awt.*;

public class Volvo240 implements ICar {
    private final Car car;
    public final static double trimFactor = 1.25;

    public Volvo240() {
        car = new Car(Color.BLACK, 100, "Volvo240", 4);
        stopEngine();
    }

    @Override
    public int getNrDoors() {
        return car.getNrDoors();
    }

    @Override
    public double getEnginePower() {
        return car.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return car.getColor();
    }

    @Override
    public void setColor(Color clr) {
        car.setColor(clr);
    }

    @Override
    public String getModelName() {
        return car.getModelName();
    }

    @Override
    public void startEngine() {
        car.startEngine();
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    private double speedFactor() {
        return car.getEnginePower() * 0.01 * trimFactor;
    }

    // TODO fix this method according to lab pm
    @Override
    public void gas(double amount) {
        car.incrementSpeed(amount, speedFactor());
    }

    // TODO fix this method according to lab pm
    @Override
    public void brake(double amount) {
        car.decrementSpeed(amount, speedFactor());
    }

    @Override
    public boolean engineIsRunning() {
        return car.engineIsRunning();
    }
}
