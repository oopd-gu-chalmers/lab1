import java.awt.*;
import static java.lang.System.out;

class Cars {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected double speedFactor;
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

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}

class Volvo2401 extends Cars {
    public Volvo2401(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        trimfactor = 1.25;
        double turbo = 1;
        speedFactor = 0;
        super.stopEngine();
    }
    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){

        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){

        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}

class Saab951 extends Cars {
    public Saab951(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        speedFactor = 125 * 0.01 * trimfactor;
        super.stopEngine();
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor * amount,enginePower);
    }

    public void decrementSpeed(double amount){

        currentSpeed = Math.max(getCurrentSpeed() - speedFactor * amount,0);
    }
}

class Main {
    public static void main(String[] args) {
        Cars myCars = new Cars();
        Cars mySaab95 = new Saab951();
        Cars Volvo240 = new Volvo2401();
        out.println(mySaab95.getNrDoors());
        out.println(mySaab95.nrDoors);
        out.println(Volvo240.nrDoors);
        out.println(mySaab95.speedFactor);
    }
}