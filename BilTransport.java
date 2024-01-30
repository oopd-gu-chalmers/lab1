import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;

public class BilTransport extends Car{
    private boolean rampState;
    private int maxload = 5;

    public BilTransport(){
        super(2, 60, Color.blue, "BilTransport");
        this.rampState = false;
    }

    public void raiseRamp() {
        if(getCurrentSpeed() == 0.0) {
            rampState = true;
        }
        else
            throw new IllegalArgumentException("cant raise ramp car is moving");
    }
    public void lowerRamp() {
        if(getCurrentSpeed() == 0.0) {
            rampState = false;
        }
        else
            throw new IllegalArgumentException("cant lower ramp car is moving");
    }

    public void loadCar(Car car) {
        Point2D.Double transportCoordinates = new Point2D.Double(car.getxPos(), car.getyPos());
        if(!rampState && flaket.size() <= maxload
           && car.getCordination().distance(transportCoordinates) <= 5.0) {
            flaket.push(car);
            car.getCordination().setLocation(transportCoordinates);
        }
        else
            throw new IllegalArgumentException("error");
    }
    public void unLoadCar(Car car) {
        if(!rampState && !flaket.isEmpty()) {
            flaket.pop();
        }
    }


}
