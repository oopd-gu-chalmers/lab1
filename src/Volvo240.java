package src;

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
    // TODO fix this method according to lab pm
    public void gas(double amount){
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
