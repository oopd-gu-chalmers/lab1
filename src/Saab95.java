package src;

import java.awt.*;

public class Saab95 extends Car{
    private boolean turboOn;
    public Saab95(){
        super(2, 125, 0, Color.red, "Saab95", new Point(0, 0), new Point(1, 0));
	    turboOn = false;
        stopEngine();
    }
    public void setTurboOn(){
	    turboOn = true;
    }
    public void setTurboOff(){
	    turboOn = false;
    }
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new RuntimeException("Fucking idiot");
        }}
        // TODO fix this method according to lab pm
    public void brake(double amount){
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new RuntimeException("Fucking idiot");
        }
        }

    }