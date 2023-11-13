package assets.elements.vehicles.cars.trucks;
import assets.elements.vehicles.Car;
import assets.elements.vehicles.engines.Engine;
import assets.elements.vehicles.cars.Truck;
import assets.storages.StorageStack;


import java.awt.*;

public final class ManTGX extends Truck {
    private final StorageStack<Car> storage;
    private static final int maxStorageSize = 6;
    private static final double reach = 5;
    private static final double maxHeight = 2;

    public ManTGX(){
        super(2, new Engine(450, 500), "ManTGX", Color.RED, 3, 20000);
        this.storage = new StorageStack<>(this, maxStorageSize);
    }


    public void retractTray(){
        setTrayRetracted(true);
    }

    public void extendTray(){
        if (isStarted()){
            System.out.println("Engine must be OFF to extend tray");
            return;
        }
        setTrayRetracted(false);
    }

    public void loadCar(Car car) {

        if (car instanceof ManTGX) {
            System.out.println("ManTGX cannot carry other ManTGX's");
            return;
        }
        if (car.getHeight() > maxHeight) {
            System.out.printf("%s is too high%n", car);
            return;
        }

        if (distanceTo(car) > reach) {
            System.out.printf("%s is too far away%n", car);
            return;
        }

        storage.add(car);
    }

    public void unloadCar() {
        if (!isTrayRetracted()) return;
        storage.pop(getRelativePosition(180, -2));
    }

    @Override
    public void start(){
        if (isTrayRetracted()) {
            super.start();
        }
    }

    @Override
    public double getWeight() {
        double w = 0;
        for (Car car : storage.getStorageItems()){
            w += car.getWeight();
        }
        return super.getWeight() + w;
    }
}
