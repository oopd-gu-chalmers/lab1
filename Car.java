import java.awt.*;
import java.util.Objects;

public abstract class Car implements Movable{
    // Protected makes them visabel to sub-class and the packege but not public
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected String direction = "Forward";

    protected double[] position = {0,0};

    public Car(int doors, Color col, double enginePow, String model){
        nrDoors = doors;
        color = col;
        enginePower = enginePow;
        modelName = model;
        stopEngine();
    }

    public void move(){
        switch (direction) {
            case "Right" -> position[1] += currentSpeed;
            case "Left" -> position[1] -= currentSpeed;
            case "Forward" -> position[0] += currentSpeed;
            case null, default -> position[0] -= currentSpeed;
        }
    }

    public void turnLeft(){
        // Intel sa att jag skulle göra det
        switch (direction) {
            case "Forward" -> direction = "Left";
            case "Right" -> direction = "Forward";
            case "Backwards" -> direction = "Right";
            case null, default -> direction = "Backwards";
        }
    }

    public void turnRight(){
        switch (direction) {
            case "Forward" -> direction = "Right";
            case "Right" -> direction = "Backwards";
            case "Backwards" -> direction = "Left";
            case null, default -> direction = "Forwards";
        }
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

    public String getDirection(){
        return direction;
    }
    public double[] getPosition(){
        return position;
    }


    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

}
