import java.awt.*;
import static java.lang.System.out;

public abstract class Cars {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    public void Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);
    public abstract double speedFactor();
    public boolean turboOn;
    public static double trimfactor;


    public final int getNrDoors(){
        return nrDoors;
    }
    public final double getEnginePower(){
        return enginePower;
    }

    public final double getCurrentSpeed(){
        return currentSpeed;
    }

    public final Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
    /*
    public void incrementSpeedSaab(double amount){

        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeedSaab(double amount){

        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    public void incrementSpeedVolvo(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor * amount,enginePower);
    }

    public void decrementSpeedVolvo(double amount){

        currentSpeed = Math.max(getCurrentSpeed() - speedFactor * amount,0);
    }
    */
}

public class Volvo2401 extends Cars {
    public Volvo2401(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        super(nrDoors,color,enginePower,modelName)
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        trimfactor = 1.25;
        super.stopEngine();
    }
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimfactor;
    }
    @Override
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor * amount,enginePower);
    }
    @Override
    public void decrementSpeed(double amount){

        currentSpeed = Math.max(getCurrentSpeed() - speedFactor * amount,0);
    }
}

public class Saab951 extends Cars {
    public Saab951(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Saab95";
        super.stopEngine();
    }
    protected boolean turboOn = false;
    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){

        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    @Override
    public void decrementSpeed(double amount){

        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }


}

class Main {
    public static void main(String[] args) {
        Cars myCars = new Cars();
        Saab951 mySaab95 = new Saab951();
        Volvo2401 myVolvo240 = new Volvo2401();
        out.println(mySaab95.getNrDoors());
        out.println(mySaab95.nrDoors);
        out.println(myVolvo240.nrDoors);
        out.println(myVolvo240.speedFactor());
        out.println(mySaab95.speedFactor());
    }
}