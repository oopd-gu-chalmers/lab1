import java.awt.*;

public class Saab95 implements ICar {
    private Car parent;
    public boolean turboOn;
    private final Car car;

    public Saab95() {
        car = new Car(Color.RED, 125, "Saab95", 2);
        turboOn = false;
        parent.stopEngine();
        loader = null;
        car.stopEngine();
    }

    public int getNrDoors() {
        return car.getNrDoors();
    }

    public double getEnginePower() {
        return car.getEnginePower();
    }

    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    public Color getColor() {
        return car.getColor();
    }

    public void setColor(Color clr) {
        car.setColor(clr);
    }

    @Override
    public String getModelName() {
        return car.getModelName();
    }

    public void startEngine() {
        car.startEngine();
    }

    public void stopEngine() {
        car.stopEngine();
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
        return car.getEnginePower() * 0.01 * turbo;
    }

    @Override
    public boolean engineIsRunning() {
        return car.engineIsRunning();
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        car.incrementSpeed(amount, speedFactor());
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        parent.decrementSpeed(amount, speedFactor());
        car.decrementSpeed(amount, speedFactor());
    }
}
