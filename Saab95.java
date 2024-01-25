import java.awt.*;

public class Saab95 extends Car{
    public boolean turboOn;

    public Saab95(){
        super(2,125, Color.red, "Saab95"); //nrDoors = 2; color = Color.red; enginePower = 125; modelName = "Saab95";
        turboOn = false;
    } //Konstruktor
    
    public void setTurboOn() {turboOn = true; }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    public double speedFactor(){ //PUBLIC???
        double turbo = 1;
        if(turboOn) turbo = 1.3; //If a saab has turboOn it has been fitted with 30% stronger brakes, lets say they get 30% better when turbo is on.
        return enginePower * 0.01 * turbo;
    }


}

