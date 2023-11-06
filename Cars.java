import java.awt.*;
import static java.lang.System.out;

class Cars {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

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

class Volvo2401 extends Cars {
    public Volvo2401(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        trimfactor = 1.25;
        super.stopEngine();
    }
    public double speedFactor(){
        return enginePower * 0.01 * trimfactor;
    }


}

class Saab951 extends Cars {
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

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
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