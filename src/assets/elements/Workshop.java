package assets.elements;

import assets.storages.Storage;

/**
 * A Workshop is an Element which can store a set number of a Vehicle type.
 * @param <T> The Vehicle type which the Workshop can store
 */
public class Workshop<T extends Vehicle> extends Element{

    private final Storage<T> storage;
    private final int maxVehicleCount;

    /**
     * Create a Workshop
     * @param maxVehicleCount the maximum number of vehicles allowed in the Workshop
     */
    public Workshop(int maxVehicleCount){
        this.maxVehicleCount = maxVehicleCount;
        this.storage = new Storage<>(this, maxVehicleCount);
    }

    /**
     * Add a vehicle to the Workshop
     * @param vehicle Vehicle to add
     */
    public void submit(T vehicle){
        storage.add(vehicle);
    }

    /**
     * Retrieve a Vehicle from the Workshop
     * @param vehicle Vehicle to retrieve
     */
    public void retrieve(T vehicle){
        storage.remove(vehicle, getRelativePosition(0, 5));
    }

    /**
     * @return the maximum number of vehicles allowed in the Workshop
     */
    public int getMaxVehicleCount() {
        return maxVehicleCount;
    }
    public int getCurrentVehicleCount(){
        return storage.getItemCount();
    }
}
