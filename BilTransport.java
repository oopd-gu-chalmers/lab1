import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;

public class BilTransport extends Car implements HasRamp {
    private Ramp ramp = new Ramp();
    private boolean rampState;
    private Deque<Car> flaket;
    private final int MAXLOAD;

    public BilTransport(){
        super(2, 90, Color.red, "BilTransport");
        this.flaket = new ArrayDeque<>();
        this.rampState = true;
        this.MAXLOAD = 5;
    }

    public Deque<Car> getFlak() { return flaket; }
    public Ramp getRamp() { return ramp; }

    @Override
    public void raiseRamp() {
        ramp.raiseRamp(getCurrentSpeed(), rampState);
    }

    @Override
    public void lowerRamp() {
        ramp.lowerRamp(getCurrentSpeed(), rampState);
    }

    public void loadCar(Car car) {
        if(!ramp.getRampState() && flaket.size() <= MAXLOAD && car.getPosition().distance(getPosition()) <= 5.0) {
            flaket.push(car);
            updateBilTransport();
        } else throw new IllegalArgumentException("Cannot load Car!");
    }

    public void updateBilTransport () {
        for (Car c: this.flaket) {
            c.getPosition().setLocation(getPosition());
        }
    }

    public void unLoadCar() {
        if(!rampState && !flaket.isEmpty()) {
            flaket.removeLast();
        }
    }

    @Override
    public void move() {
        if (!ramp.getRampState()) {
        } else {
            super.move();
            updateBilTransport();
        }

    }

    private double speedFactor() {
        double trimFactor = 0.8;
        return this.getCurrentSpeed() * 0.01 * trimFactor;
    }
    protected void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + speedFactor() * amount, this.getEnginePower()));
    }
    protected void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - speedFactor() * amount, 0));
    }
}
