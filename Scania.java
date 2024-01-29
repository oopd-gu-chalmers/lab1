import java.awt.*;

public class Scania extends Car {

    protected double trailerAngle;
    public Scania() {
        super(2,250, "Scania");
        setColor(Color.pink);
    }

    @Override
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1 && trailerAngle == 0) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Gas input either too high or too low, or trailer angle not 0: ");
        }
    }
    // Göra en klass för fordon i allmänhet för att hänvisa gas och broms likt incrementspeed och liknande

    protected void incrementAngle(double amount) {
        trailerAngle = trailerAngle + amount;
    }

    protected void decrementAngle(double amount) {
        trailerAngle = trailerAngle - amount;
    }

    //att sänka och höja rampen bör vara protected och komplitterat med en get funktion
    protected void raiseRamp(double amount) {
        if ((trailerAngle + amount) <= 70 && (currentSpeed == 0)) {
            incrementAngle(amount);
        }
        else {
            throw new IllegalArgumentException("Max angle reached or truck might be moving: ");
        }
    }

    protected void lowerRamp(double amount) {
        if (trailerAngle - amount >= 0) {
            decrementAngle(amount);
        }
        else {
            throw new IllegalArgumentException("Min angle reached: ");
        }
    }
//
    public double getRampAngle(){
        return trailerAngle;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.02;
    }

    // increment speed och decrement speed kanske kan flyttas eftersom det
    // inte finns någon direkt koppling mellan hastighetsändringarna och
    // hanteringen av rampen.?
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
