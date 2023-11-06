import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn; //egen variabel
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }
    
    private void setTurboOn(){
	    turboOn = true;
    }

    private void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){ //ser olika ut, turbo istället för trimfactor
        double turbo = 1; 
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    protected void incrementSpeed(double amount){ //olika, ingen math.min
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    protected void decrementSpeed(double amount){ //olika, ingen math.max
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
}
