import java.awt.*;

public class Saab95 extends Car implements Turbo{

    protected boolean turboOn;

    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }
    
    public void setTurboOn(){
	    turboOn = true;
        System.out.println("Turbo on!");
    }

    public void setTurboOff(){
	    turboOn = false;
        System.out.println("Turbo off!");
    }

    
    public double speedFactor(){
        double turbo = 1; 
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
