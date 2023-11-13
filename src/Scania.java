import java.awt.*;

public class Scania extends Car{

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

    public void raiseBack(double amount) {
        if (amount >= 0) {
            tilt = Math.min(tilt + amount, 70);
        }
    }

    public void lowerBack(double amount) {
        if (amount >= 0){
            tilt = Math.max(tilt - amount, 0);
        }
    }
}
