import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

public class TransportTruck extends Cars{
    private final int maxLoadAmount;
    private final Ramp ramp;
    private Storage<Cars> transportedCars;
    public TransportTruck(){
        super(2,70, Color.GREEN,"Transport Truck");
        // super(nrDoors,enginePower,color,modelName);
        super.stopEngine();
        maxLoadAmount = 2+(1);
        this.ramp = new Ramp(1);
        transportedCars = new Storage<Cars>(2);
    }

    public double speedFactor() {
        if (ramp.getRampAngle() == 0) {
            return getEnginePower() * 0.01;
        }
        else
            return 0;
    }

    public void raiseRamp(){
        if (getCurrentSpeed() == 0){
            ramp.raiseRamp();
        }
    }
    public void lowerRamp(){
        if (getCurrentSpeed() == 0) {
            ramp.lowerRamp();
        }
    }

    public void loadCar(Cars car){
        if(storage.size() < maxLoadAmount && ramp.getRampAngle() == 1 && overlaps(car)) {
            storage.add(car);
            System.out.println(car.getModelName() + " is on the transport");
        }
        else {
            System.out.println("The truck is full");
        }
    }

    public void unloadCar(){
        if(storage.size() > 1 && ramp.getRampAngle() == 1){
            System.out.println("This car was unloaded: "+storage.getLast());
            storage.removeLast();
        }
        else {
            System.out.println("There is no Vehicles on the truck");
        }

    }

    private boolean overlaps(Cars car){
        return (abs(this.getPositionX() - car.getPositionX()) < 1) && (abs(this.getPositionY() - car.getPositionY()) < 1);
    }

    public void getStorage(){
        if (storage.size() == 1){
            System.out.println("There is no Vehicles on the truck");
        }
        for (int i = 1; i < storage.size(); i++){
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
