import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;

public class BilTransport extends Car implements hasRamp{
    private Ramp ramp = new Ramp();
    private boolean rampState;
    private Deque<Car> flaket;
    private final int MAXLOAD;

    public BilTransport(){
        super(2, 90, Color.red, "BilTransport");
        this.flaket = new ArrayDeque<>();
        this.rampState = false;
        this.MAXLOAD = 5;
    }
    public Deque<Car> getFlak() { return flaket; }

    public Ramp getRamp() { return ramp;}
    public void raiseRamp() {
        ramp.raiseRamp(getCurrentSpeed(), rampState);
    }

    public void lowerRamp() {
        ramp.lowerRamp(getCurrentSpeed(), rampState);
    }

    public void loadCar(Car car) {
        Point2D.Double transportCoordinates = new Point2D.Double(car.getxPos(), car.getyPos());
        if(!rampState && flaket.size() <= MAXLOAD
                && car.getCordination().distance(transportCoordinates) <= 5.0) {
            flaket.push(car);
            car.getCordination().setLocation(transportCoordinates);
        }
        else throw new IllegalArgumentException("error");
    }

    public void unLoadCar() {
        if(!rampState && !flaket.isEmpty()) {
            flaket.removeLast();
        }
    }

    @Override
    public void gas(double amount) {
        if (bool(amount) && rampState ) {
            incrementSpeed(amount);
            this.setCurrentSpeed(Math.min(this.getCurrentSpeed(), getEnginePower()));
        }
        this.move();
    }

    private boolean bool (double amount) { return this.getCurrentSpeed() >= 0 && this.getCurrentSpeed() <=
            getEnginePower() && (amount >= 0 && amount <= 1);
    }

    private double speedFactor() {
        double trimFactor = 0.8;
        return this.getEnginePower() * 0.01 * trimFactor;
    }
    @Override
    protected void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + speedFactor() * amount, this.getEnginePower()));
    }
    @Override
    protected void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - speedFactor() * amount, 0));
    }

    @Override
    public void move(){
        if (rampState) {
            super.move();
            updateBilTransport();
        }
}
    public void updateBilTransport () {
        Point2D.Double transportCoordinates = new Point2D.Double(getxPos(), getyPos());
        for (Car c: this.getFlak()) {
            c.getCordination().setLocation(transportCoordinates);
        }
    }
    }
