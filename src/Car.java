import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public abstract class Car implements Movable{
    // Protected makes them visabel to sub-class and the packege but not public
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private String direction = "Forward";
    private double[] position = {0,0};

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
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

    public void setCurrentSpeed(double input){
        currentSpeed = input;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public String getModelName() {
        return modelName;
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

    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    public void gas(double amount){
        if (!valueBetween0And1(amount)) {
            System.out.println("BAD INPUT");
            return;
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (!valueBetween0And1(amount)) {
            System.out.println("BAD INPUT");
            return;
        }
        decrementSpeed(amount);
    }

    protected boolean valueBetween0And1(double check){
        if (check > 0 && check < 1){
            return true;
        }else{
            return false;
        }
    }


    // not tested but is only for when trying porgram
    // it returns nothing and changes nothing so nothing
    // to test.
    public void getInfo(){
        System.out.println("Col: " + getColor());
        System.out.println("Doors: " + getNrDoors());
        System.out.println("Pow: " + getEnginePower());
        System.out.println("Speed: " + getCurrentSpeed());

        System.out.println("Dir: " + getDirection());
        System.out.println("Pos: " + Arrays.toString(getPosition()));

        System.out.println();
    }
}
