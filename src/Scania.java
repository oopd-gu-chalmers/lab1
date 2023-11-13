import java.awt.*;

public class Scania extends Cars {
    private double bedAngle;
    public Scania(){
        super(2,70, Color.GREEN,"Scania");
        // super(nrDoors,enginePower,color,modelName);
        bedAngle = 0;
        super.stopEngine();
    }
    public double speedFactor() {
        if (bedAngle == 0) {
            return getEnginePower() * 0.01;
        }
        else
            return 0;
    }
    @Override
    public void startEngine() {
        if (bedAngle == 0){
            super.startEngine();
        }
    }

    public double getBedAngle() {
        return bedAngle;
    }

    public void raiseBedAngle(double amount) {
        if (getCurrentSpeed() == 0) {
            bedAngle = Math.min(bedAngle + amount, 70);
        }
    }
    public void lowerBedAngle(double amount) {
        if (getCurrentSpeed() == 0) {
            bedAngle = Math.max(bedAngle - amount, 0);
        }
    }
}
