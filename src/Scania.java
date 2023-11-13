import java.awt.*;

public class Scania extends Cars {
    public TruckBed truckBed;
    public Scania(){
        super(2,70, Color.GREEN,"Scania");
        // super(nrDoors,enginePower,color,modelName);
        super.stopEngine();
        this.truckBed = new TruckBed(); // TODO


    }
    public double speedFactor() {
        if (truckBed.getBedAngle() == 0) {
            return getEnginePower() * 0.01;
        }
        else
            return 0;
    }
    @Override
    public void startEngine() {
        if (truckBed.getBedAngle() == 0){
            super.startEngine();
        }
    }
}
