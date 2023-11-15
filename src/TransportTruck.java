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
        rampUp = true;
        maxLoadAmount = 2+(1);
        storage = new ArrayList<>();
        storage.add(this);
    }

    public double speedFactor() {
        if (rampUp) {
            return getEnginePower() * 0.01;
        }
        else
            return 0;
    }
    public void raiseRamp(){
        if (super.getCurrentSpeed() == 0){
            rampUp = true;
            System.out.println(super.getCurrentSpeed());
        }
    }
    public void lowerRamp(){
        if (super.getCurrentSpeed() == 0) {
            rampUp = false;
            System.out.println(getCurrentSpeed());
        }
    }



    public void loadCar(Cars car){
        if(storage.size() < maxLoadAmount && !rampUp && overlaps(car)) {
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

    public void getStorage(){
        for (int i = 0; i<3; i++){
            System.out.println("This Vehicle is on the truck: " + storage.get(i));
        }
    }
    @Override
    public void move(){
        super.move();
        for (int i = 1; i < storage.size(); i++){
            storage.get(i).getPosition().setLocation(this.getPositionX(),this.getPositionY());
        }
    }
}
