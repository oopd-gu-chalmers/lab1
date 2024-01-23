import java.awt.*;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25; // Skapa getter metod istället för att ha denna public?
    public Volvo240(){
        super(4, 100, 0, Color.black, "Volvo240", new Point(0, 0), new Point(1, 0));
        stopEngine();
    }
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
