import java.awt.*;

public class Scania extends Car implements Trailer{

    protected double trailerAngle;
    private static final double maxPlatformAngle = 70;
    private static final double minPlatformAngle = 0;
    public Scania() {
        super(2,250, Color.pink, "Scania");
    }

    @Override
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1 && trailerAngle == 0) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Gas input either too high or too low, or trailer angle not 0: ");
        }
    }
    // Göra en klass för fordon i allmänhet för att hänvisa gas och broms likt incrementspeed och liknande?

    protected void incrementAngle(double amount) {
        trailerAngle = trailerAngle + amount;
    }

    protected void decrementAngle(double amount) {
        trailerAngle = trailerAngle - amount;
    }

    public void raiseRamp(double amount) {
        if ((trailerAngle + amount) <= 70 && (currentSpeed == 0)) {
            incrementAngle(amount);
        }
        else {
            throw new IllegalArgumentException("Max angle reached or truck might be moving: ");
        }
    }

    public void lowerRamp(double amount) {
        trailerAngle = Math.max(trailerAngle+amount, minPlatformAngle);
    }
//
    public double getRampAngle(){
        return trailerAngle;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.02;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
