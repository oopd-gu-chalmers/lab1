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
    public Volvo2401(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        trimfactor = 1.25;
        super.stopEngine();
    }
}

class Saab951 extends Cars {
    public Saab951(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        super.stopEngine();
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
    }
}