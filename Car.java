import java.awt.*;

public class Car {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    //eventuellt skapa Konstruktor??

    protected int getNrDoors() {

        return nrDoors;
    }

    protected double getEnginePower() {
        return enginePower;
    }


    protected double getCurrentSpeed() {
        return currentSpeed;
    }

    protected Color getColor() {
        return color;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }
    //ska speedfactor, inctement/decrement speed? vara med i och med att båda klasserna har det?



}