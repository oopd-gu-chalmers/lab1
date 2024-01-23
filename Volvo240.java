import java.awt.*;
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;


    public Volvo240() {
        super(4, 100, 0, Color.black, "Volvo240", new Point(0,0));
        //nrDoors = 4;
        //color = Color.black;
        //enginePower = 100;
        //modelName = "Volvo240";
        stopEngine();
    }

    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
