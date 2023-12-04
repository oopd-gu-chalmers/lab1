import java.awt.*;

public class Scania implements Movable{

    private double tilt = 0;
    private Truck truck;

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
        if ((amount >= 0) && (currentSpeed == 0)) {
            tilt = Math.min(tilt + amount, 70);
            backIsOpen = true;
        }
    }

    public void lowerBack(double amount) {
        if (amount >= 0) {
            tilt = Math.max(tilt - amount, 0);
            if (tilt == 0) {
                backIsOpen = false;
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
}
