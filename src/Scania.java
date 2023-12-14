import java.awt.*;

public class Scania implements Movable, Engine, HasName, Back{

    private double tilt = 0;
    private final Truck truck = new Truck();
    private final String modelName = "Scania";
    public Scania(){
    }

    public double getTilt() {
        return tilt;
    }

    public void raiseBack() {
        raiseBack(10);
    }

    public void lowerBack() {
        lowerBack(10);
        System.out.println("Back lowered!");
    }

    public void raiseBack(double amount) {
        if ((amount >= 0) && (truck.getCurrentSpeed() == 0)) {
            tilt = Math.min(tilt + amount, 70);
            truck.setBackIsOpen(true);
            System.out.println("Beck raised!");
        }
    }

    public void lowerBack(double amount) {
        if (amount >= 0) {
            tilt = Math.max(tilt - amount, 0);
            if (tilt == 0) {
                truck.setBackIsOpen(false);
            }
        }
    }

    public void setPosition(double[] position) {
        truck.setPosition(position);
    }

    public double[] getPosition() {
        return truck.getPosition();
    }

    public void setCurrentSpeed(double currentSpeed) {
        truck.setCurrentSpeed(currentSpeed);
    }

    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }

    public void move() {
        truck.move();
    }

    public void turnLeft() {truck.turnLeft();}

    public void turnRight() {
        truck.turnRight();
    }

    public void startEngine() {
        truck.startEngine();
    }

    public void stopEngine() {
        truck.stopEngine();
    }

    public void gas(double amount) {
        truck.gas(amount);
    }

    public void brake(double amount) {
        truck.brake(amount);
    }

    public String getName() {
        return this.modelName;
    }
}
