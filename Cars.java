import java.awt.*;
import static java.lang.System.out;

public abstract class Cars extends Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Point position;

    public Cars(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = new Point(0,0);
        // This.direction IDK HELP, use enum?????????!!!!!!!
    }

    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);
    public abstract double speedFactor();
    public boolean turboOn;
    private double currentSpeed; // The current speed of the car
    private enum direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public void setCurrentSpeed(double amount){
        this.currentSpeed = amount;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
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
}

class Volvo2401 extends Cars {
    private final double trimfactor;
    public Volvo2401(){
        super(4,100,Color.black,"Volvo240");
        // super(nrDoors,enginePower,color,modelName);
        this.trimfactor = 1.25;
        super.stopEngine();
    }
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimfactor;
    }
    @Override
    public void incrementSpeed(double amount){
        super.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }   // Current speed not set
    @Override
    public void decrementSpeed(double amount){
        super.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }   // Current speed not set
}

class Saab951 extends Cars {
    private boolean turboOn;
    public Saab951(){
        super(2,125,Color.red,"Saab95");
        // super(nrDoors,enginePower,color,modelName);
        this.setTurboOff();
        super.stopEngine();
    }
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
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){
        super.setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }
    @Override
    public void decrementSpeed(double amount){
        super.setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }


}

class Main {
    public static void main(String[] args) {
        //Cars myCars = new Cars();
        Saab951 mySaab95 = new Saab951();
        Volvo2401 myVolvo240 = new Volvo2401();
        //out.println(mySaab95.getNrDoors());
        //out.println(mySaab95.nrDoors);
        out.println(myVolvo240.getNrDoors());
        out.println(myVolvo240.speedFactor());
        out.println(myVolvo240.getCurrentSpeed());
        myVolvo240.incrementSpeed(2);
        out.println(myVolvo240.getCurrentSpeed());
        myVolvo240.incrementSpeed(2);
        out.println(myVolvo240.getCurrentSpeed());
        out.println(mySaab95.getCurrentSpeed());
        mySaab95.setTurboOn();
        out.println(mySaab95.speedFactor());
    }
}