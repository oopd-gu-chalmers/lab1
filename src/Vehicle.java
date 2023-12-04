import java.awt.*;

public abstract class Vehicle implements Movable{
    protected  int nrDoors;
    protected double enginePower;
    protected double currentSpeed = 0;
    protected Color color;
    protected String modelName;
    public double[] getPosition() {
        return position;
    }
    public void setPosition(double[] position) {
        this.position = position;
    }
    public double[] getDirection() {
        return direction;
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

    public abstract double speedFactor();

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount) {
        if ((amount >= 0) && (amount <= 1)) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if ((amount >= 0) && (amount <= 1)) {
            decrementSpeed(amount);
        }
    }



}