import java.awt.*;

public class Saab95 extends Car {

    protected boolean turboOn; //egen variabel

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
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){ //ser olika ut, turbo istället för trimfactor
        double turbo = 1; 
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
