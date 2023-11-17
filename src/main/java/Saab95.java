import java.awt.*;

public class Saab95 implements ICar {
    private Car parent;
    public boolean turboOn;

    public Saab95() {
        parent = new Car(Color.RED, 125, "Saab95", 2);
        turboOn = false;
        parent.stopEngine();
    }

    public int getNrDoors() {
        return parent.getNrDoors();
    }

    public double getEnginePower() {
        return parent.getEnginePower();
    }

    public double getCurrentSpeed() {
        return parent.getCurrentSpeed();
    }

    public Color getColor() {
        return parent.getColor();
    }

    public void setColor(Color clr) {
        parent.setColor(clr);
    }

    @Override
    public String getModelName() {
        return parent.getModelName();
    }

    public void startEngine() {
        parent.startEngine();
    }

    public void stopEngine() {
        parent.stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    private double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return parent.getEnginePower() * 0.01 * turbo;
    }

    @Override
    public boolean engineIsRunning() {
        return parent.engineIsRunning();
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        parent.incrementSpeed(amount, speedFactor());
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        parent.decrementSpeed(amount, speedFactor());
    }
}
