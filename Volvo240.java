import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25; //Gjorde private
    
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }


    
    public double speedFactor(){ //Annorlunda mellan bilarna
        return enginePower * 0.01 * trimFactor; //Skillnad i trimfactor, är turbo i Saab
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    } //Har math.min med enginepower som andra faktor

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    } //Har math.min med 0 som andra faktor

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
