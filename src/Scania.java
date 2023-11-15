import java.awt.*;

public class Scania extends Car implements Back{

    private double tilt = 0;

    public Scania(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Scania";
    }

    public double getTilt() {
        return tilt;
    }

    public double speedFactor() {
        return 1; //TODO: Fixa värden
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
        }
    }

    public void lowerBack(double amount) {
        if (amount >= 0){
            tilt = Math.max(tilt - amount, 0);
        }
    }

    @Override
    public void gas() {
        if (tilt == 0) super.gas();
    }
}
