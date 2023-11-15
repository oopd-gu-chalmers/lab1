import java.awt.*;

public class Scania extends Truck{

    private double tilt = 0;

    public Scania(){
        super();
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Scania";
    }

    public double getTilt() {
        return tilt;
    }

    public void raiseBack() {
        raiseBack(10);
    }

    public void lowerBack() {
        lowerBack(10);
    }

    public void raiseBack(double amount) {
        if ((amount >= 0) && (currentSpeed == 0)) {
            tilt = Math.min(tilt + amount, 70);
            backIsClosed = false;
        }
    }

    public void lowerBack(double amount) {
        if (amount >= 0){
            tilt = Math.max(tilt - amount, 0);
            if (tilt == 0) backIsClosed = true;
        }
    }
}
