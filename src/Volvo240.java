import java.awt.*;

public class Volvo240 extends Car {

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

    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    } //Har math.min med enginepower som andra faktor

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    } //Har math.min med 0 som andra faktor
}
