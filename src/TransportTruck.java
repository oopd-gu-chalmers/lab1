import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

public class TransportTruck extends Cars{
    private boolean ramp;
    private List<Cars> storage;
    private final int maxLoadAmount;
    public TransportTruck(){
        super(2,70, Color.GREEN,"Transport Truck");
        // super(nrDoors,enginePower,color,modelName);
        super.stopEngine();
        ramp = true;
        maxLoadAmount = 2;
    }

    public double speedFactor() {
        if (ramp) {
            return getEnginePower() * 0.01;
        }
        else
            return 0;
    }
    public void raiseRamp(){
        if (getCurrentSpeed() == 0){
            ramp = true;
        }
    }
    public void lowerRamp(){
        ramp = false;
    }



    public void loadCar(Cars car){
        if(storage == null || storage.size() < maxLoadAmount && !ramp && overlaps(car)) {
            storage.add(car);
            System.out.println(car.getModelName() + " is on the transport");
        }
        else {
            System.out.println("The truck is full");
        }
    }
    /*
    public void unloadCar(){
        if(!storage.isEmpty() && !ramp){

        }
        else {

        }
        //TODO
    }
*/
    private boolean overlaps(Cars car){
        return (abs(this.getPositionX() - car.getPositionX()) < 1) && (abs(this.getPositionY() - car.getPositionY()) < 1);
    }
}
