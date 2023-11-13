package elements;

import storages.Storage;

public class Workshop<T extends Vehicle> extends Element{

    private final Storage<T> storage;
    private final int maxVehicleCount;

    public Workshop(int maxVehicleCount){
        this.maxVehicleCount = maxVehicleCount;
        this.storage = new Storage<>(this, maxVehicleCount);
    }

    public void submit(T vehicle){
        storage.add(vehicle);
    }

    public void retrieve(T vehicle){
        storage.remove(vehicle, getRelativePosition(0, 5));
    }

    public int getMaxVehicleCount() {
        return maxVehicleCount;
    }
}
