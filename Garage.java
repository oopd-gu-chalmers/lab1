import java.awt.*;

public class Garage<T extends Car> implements Loadable<T>{

    private QueueLoader<T> loadedCars;
    private Point garageLocation;

    public Garage(int capacity) {
        loadedCars = new QueueLoader<>(capacity);
        garageLocation = new Point();

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