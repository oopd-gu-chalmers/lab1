package elements;

import java.util.Set;

public class Workshop<T extends Vehicle> implements StorageSet<T>{


    public Workshop(Set<T> acceptedVehicles, int maxVehicleCount){

    }
    @Override
    public int getStorageSize() {
        return 0;
    }

    @Override
    public void addElement(T element) {

    }

    @Override
    public void removeElement(T element) {

    }
}
