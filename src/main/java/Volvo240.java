import java.awt.*;

public class Volvo240 implements ICar {
    private Car parent;
    public final static double trimFactor = 1.25;

    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }
    
    @Override
    public int getNrDoors(){
        return nrDoors;
    }
    @Override
    public double getEnginePower(){
        return enginePower;
    }

    @Override
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public void setColor(Color clr){
	    color = clr;
    }

    @Override
    public String getModelName() {
        return null;
    }

    @Override
    public void startEngine(){
	    currentSpeed = 0.1;
    }

    @Override
    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    @Override
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    @Override
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public boolean engineIsRunning() {
        return false;
    }
}
