package assets.elements.vehicles.boats.motorizedBoats;

import assets.elements.vehicles.Car;
import assets.elements.vehicles.engines.Engine;
import assets.elements.vehicles.boats.MotorizedBoat;
import assets.storages.Storage;
import assets.storages.StorageQueue;

import java.awt.*;
import java.util.ArrayList;

public class Ferry2000 extends MotorizedBoat {
    private final ArrayList<StorageQueue<Car>> lanes;
    private final int laneCount;
    private static final double reach = 5;
    public Ferry2000(int laneCount, int laneSize) {
        super(new Engine(2000, 3500), "Ferry2000", Color.CYAN, 10, 50000, 10);
        lanes = new ArrayList<>();
        this.laneCount = laneCount;
        for(int i = 0; i < laneCount; i++){
            lanes.add(new StorageQueue<>(this, laneSize));
        }
    }

    public void loadCar(Car car, int laneNr){
        if (laneNr <= 0 | laneNr > laneCount){
            System.out.println("That lane number does not exist!");
            return;
        }

        if (distanceTo(car) > reach) {
            System.out.printf("%s is too far away%n", car);
            return;
        }

        lanes.get(laneNr - 1).add(car);
    }

    public Car unloadCar(int laneNr){
        if (laneNr <= 0 | laneNr > laneCount){
            System.out.println("That lane number does not exist!");
            return null;
        }
        return lanes.get(laneNr - 1).poll(getRelativePosition(0, 5));
    }

    @Override
    public double getWeight() {
        double w = 0;
        for (Storage<Car> storage : lanes) {
            for (Car car : storage.getStorageItems()) {
                w += car.getWeight();
            }
        }
        return super.getWeight() + w;
    }
}
