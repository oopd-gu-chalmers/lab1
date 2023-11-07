import java.awt.*;

abstract public  class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    public String modelName; // The car model name
    protected double direction;
    protected double xPosition;
    protected double yPosition;

    public int getNrDoors(){
        return nrDoors;
    } //Get number of doors
    public double getEnginePower(){
        return enginePower;
    } //Get Engine Power

    public double getCurrentSpeed(){
        return currentSpeed;
    }// Get Current Speed

    public Color getColor(){
        return color;
    }// Get Color

    public void setColor(Color clr){
        color = clr;
    } // Set Color

    public void startEngine(){
        currentSpeed = 0.1;
    } // Start Engine

    public void stopEngine(){currentSpeed = 0;}// Stops Engine

    public double getDirection(){return direction;}// Returns Direction

    public double[] getPosition(){return new double[]{xPosition,yPosition};}// Returns Position

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    public void move() {
        xPosition += currentSpeed * Math.cos(direction);
        yPosition += currentSpeed * Math.sin(direction);
    }
    public void turnLeft(double radians) {
        direction += radians;
    }
    public void turnRight(double radians) {
        direction -= radians;
    }

    public void gas(double amount){
        if (amount > 0){
            incrementSpeed(Math.min(amount,1));
        }
    }
    public void brake(double amount){
        if (amount > 0) {
            decrementSpeed(Math.min(amount,1));
        }
    }
}

