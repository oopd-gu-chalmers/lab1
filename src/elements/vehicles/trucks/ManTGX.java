package elements.vehicles.trucks;
import storages.StorageStack;
import elements.vehicles.Car;
import elements.vehicles.Truck;


import java.awt.*;

public final class ManTGX extends Truck {
    private final StorageStack<Car> storage;
    private static final int maxStorageSize = 6;
    public ManTGX(){
        super(2, 450, "ManTGX", Color.RED);
        this.storage = new StorageStack<>(this, maxStorageSize);
    }


    public void retractTray(){
        setTrayRetracted(true);
    }

    public void extendTray(){
        if (isEngineOn()){
            System.out.println("Engine must be OFF to extend tray");
            return;
        }
        setTrayRetracted(false);
    }

    public void loadCar(Car car) {
        final double reach = 5;

        if (car instanceof ManTGX) {
            System.out.println("ManTGX cannot carry other ManTGX's");
            return;
        }
        if (distanceTo(car) > reach) {
            System.out.printf("%s is too far away", car.getModelName());
            return;
        }

        storage.add(car);
    }

    public void unloadCar() {
        if (!isTrayRetracted()) return;
        storage.pop(getRelativePosition(180, -2));
    }
}
