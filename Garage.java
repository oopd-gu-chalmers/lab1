import java.awt.*;

public class Garage<T extends Car> implements Loadable<T>{

    private QueueLoader<T> loadedcars;
    private Point garageLocation;

    public Garage(int capacity) {
        loadedcars = new QueueLoader<>(capacity);
        garageLocation = new Point();

    }
    public Point getLocation() {
        return garageLocation;
    }
    public void load(T car) {
        // TODO
        loadedcars.load(car);  // Delegation
    }
    public T unload() {
        return loadedcars.unload(); // Delegation
    }

}