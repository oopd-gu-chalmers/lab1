import java.awt.*;

public class Scania extends Car implements Movable{

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

    }
}
