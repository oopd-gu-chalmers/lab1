import java.awt.*;

public class Volvo240 implements ICar {
    private final Car parent;
    public final static double trimFactor = 1.25;

    public Volvo240() {
        parent = new Car(Color.BLACK, 100, "Volvo240", 4);
        stopEngine();
    }

    @Override
    public int getNrDoors() {
        return parent.getNrDoors();
    }

    @Override
    public double getEnginePower() {
        return parent.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return parent.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return parent.getColor();
    }

    @Override
    public void setColor(Color clr) {
        parent.setColor(clr);
    }

    @Override
    public String getModelName() {
        return parent.getModelName();
    }

    @Override
    public void startEngine() {
        parent.startEngine();
    }

    @Override
    public void stopEngine() {
        parent.stopEngine();
    }

    private double speedFactor() {
        return parent.getEnginePower() * 0.01 * trimFactor;
    }

    // TODO fix this method according to lab pm
    @Override
    public void gas(double amount) {
        parent.incrementSpeed(amount, speedFactor());
    }

    // TODO fix this method according to lab pm
    @Override
    public void brake(double amount) {
        parent.decrementSpeed(amount, speedFactor());
    }

    @Override
    public boolean engineIsRunning() {
        return parent.engineIsRunning();
    }
}
