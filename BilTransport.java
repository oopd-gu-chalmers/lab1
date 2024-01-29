import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BilTransport extends Car{
    private boolean rampState;
    private Deque<Car> flaket = new ArrayDeque<>();
    private int maxload = 4;
    private final double maxReach = 10.0;

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
        double x = Math.abs(car.getxPos() - this.getxPos());
        double y = Math.abs(car.getyPos() - this.getyPos());
        if(!rampState && flaket.size() <= maxload
           && x <= maxReach && y <= maxReach) {
            flaket.push(car);
            car.setxPos(this.getxPos());
            car.setyPos(this.getyPos());
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
