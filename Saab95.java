import java.awt.*;

public class Saab95 extends Car {

    public boolean turboOn;

    
    public Saab95(){
        super(2, 125,0, Color.red, "Saab95", new Point(0,0));
        //nrDoors = 2;
        //color = Color.red;
        //enginePower = 125;
	    turboOn = false;
        //modelName = "Saab95";
        stopEngine();
    }

    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        // The speed should not be below 0?
        currentSpeed = Math.min(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }}

