import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;

public class BilTransport extends Truck {
    private Ramp ramp = new Ramp();
    private boolean rampState;
    private Deque<Car> flaket;
    private final int MAXLOAD;

    public BilTransport(){
        this.flaket = new ArrayDeque<>();
        this.rampState = false;
        this.MAXLOAD = 5;
    }

    @Override
    public void raiseRamp() {
        ramp.raiseRamp(getCurrentSpeed(), rampState);
    }

    @Override
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
    public Deque<Car> getFlak() { return flaket; }

    public Ramp getRamp() { return ramp;}
}
