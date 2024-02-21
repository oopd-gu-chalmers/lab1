import java.awt.*;

public class Garage<T extends Car> implements Loadable<T>{

    private QueueLoader<T> loadedCars;
    private Point garageLocation;

    public Garage(int capacity, Point garageLocation) {
        loadedCars = new QueueLoader<>(capacity);
        this.garageLocation = garageLocation;

    }

    public QueueLoader<T> getLoadedCars() {
        return loadedCars;
    }
    public Point getLocation() {
        return garageLocation;
    }
    public void load(T car) {
        loadedCars.validateCarPosition(car, getLocation());
        loadedCars.load(car);  // Delegation
    }
    public T unload() {
        return loadedCars.unload(); // Delegation
    }

}