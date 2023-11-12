package elements.vehicles.trucks;
import elements.Storage;
import elements.StorageStack;
import elements.Vehicle;
import elements.vehicles.Car;
import elements.vehicles.Truck;
import elements.vehicles.passengerCars.Volvo240;

import java.awt.*;
import java.util.Stack;

public final class ManTGX extends Truck implements StorageStack<Car> {

    Stack<Car> storage = new Stack<>();
    private static final int maxStorageSize = 6;
    public ManTGX(){
        super(2, 450, "ManTGX", Color.RED);
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

    @Override
    public void addElement(Car car) {
        final double reach = 5;

        if (car instanceof ManTGX) {
            System.out.println("ManTGX cannot carry other ManTGX's");
            return;
        }
        if (distanceTo(car) > reach) {
            System.out.printf("%s is too far away", car.getModelName());
            return;
        }

        storage.addElement(car);
        car.mount(this);
    }

    @Override
    public void removeElement() {
        if (getStorageElementCount() == 0) return;
        if (!isTrayRetracted()) return;
        Car car = storage.pop();
        car.demount();
        car.setPosition(getPosition());
        car.move(-1);
    }

    @Override
    public int getStorageSize(){
        return maxStorageSize;
    }
    public int getStorageElementCount(){
        return storage.size();
    }
}
