import java.awt.*;

public class Scania implements Movable, Engine{

    private double tilt = 0;
    private final Truck truck = new Truck();
    public Scania(){
    }

    public double getTilt() {
        return tilt;
    }

    public void raiseBack() { raiseBack(10); }

    public void lowerBack() {
        lowerBack(10);
    }

    public void raiseBack(double amount) {
        if ((amount >= 0) && (truck.getCurrentSpeed() == 0)) {
            tilt = Math.min(tilt + amount, 70);
            truck.setBackIsOpen(true);
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

    public void move() {
        truck.move();
    }

    public void turnLeft() {
        truck.turnLeft();
    }

    public void turnRight() {
        truck.turnRight();
    }

    public void startEngine() {

    }

    public void stopEngine() {

    }

    public void gas(double amount) {

    }

    public void brake(double amount) {

    }
}
