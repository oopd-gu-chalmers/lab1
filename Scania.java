import java.awt.*;

public class Scania extends Car {
    private int angle;
    private final double trimFactor = 0.8;

    public Scania() {
        super(2, 80, Color.white, "Scania");
        this.angle = 0;
    }
    private double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
    @Override
    protected void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }
    @Override
    protected void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }
    public int getAngleFlak() {
        return angle;
    }
    public void setAngleFLak(int amount) {angle = amount;}

    public void lowerFlak() {
        if (getCurrentSpeed() == 0) {
            angle -= 5;
            if (angle < 0) {
                angle = 0;
            }
        }
        else
            throw new IllegalArgumentException("car is moving, can´t lower the flak!");
    }

    public void raiseFlak(){
        if(getCurrentSpeed() == 0) {
            angle += 5;
            if (angle > 70.0) {
                angle = 70;
            }
        }
        else
          throw new IllegalArgumentException("car is moving, can´t raise the flak!");
    }
}

