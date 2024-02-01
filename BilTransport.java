import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BilTransport extends Truck {
    private final Ramp ramp = new Ramp();
    private boolean rampState;
    private Deque<Car> flaket;
    private final int MAXLOAD;

    public BilTransport(){
        this.flaket = new ArrayDeque<>();
        this.rampState = false;
        this.MAXLOAD = 5;
        this.setAngle(0);
    }

    @Override
    public boolean getRampState() { return this.rampState; }

    @Override
    public void raiseRamp() {
        ramp.raiseRamp(getCurrentSpeed(), rampState);
    }

    public void lowerRamp() {
        if(this.getCurrentSpeed() == 0) {
            this.setAngle(70);
            rampState = false;
        }
        else throw new IllegalArgumentException("cant lower ramp car is moving");
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
    public void unLoadCar(Car car) {
        if(!rampState && !flaket.isEmpty()) {
            flaket.remove(car);
        }
    }
    public Deque<Car> getFlak() { return flaket; }
}
