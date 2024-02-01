import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Loader<T> implements Loadable<T> {
    protected ArrayList<T> loadedCars;
    private int maxLoadables;
    private static final int maxCarDistance = 5;


    public Loader(int maxLoadables) {
        this.maxLoadables = maxLoadables;
        this.loadedCars = new ArrayList<>();


    }

    @Override
    public void load(T car) {
        if (loadedCars.size() < maxLoadables){
            loadedCars.addLast(car);
        }
        else {
            throw new IllegalStateException("Cannot load more cars!");
        }
    }

    @Override
    public T unload() {
        if (!loadedCars.isEmpty()){
            return unloadImpl();
        }
        else {
            throw new IllegalStateException("Cannot unload more cars!");
        }
    }
    public void validateCarPosition(Car car, Point loaderposition) {
        if (!isCarWithinRange(car, loaderposition)) {
            throw new IllegalArgumentException("Car is not within range, please move closer to the transporter!");
        }
    }

    public boolean isCarWithinRange(Car car, Point loaderposition) {             // Is the car within range of the transporter?
        Point carPosition = car.getPosition();
        return carPosition.distance(loaderposition) <= maxCarDistance;
    }

    protected abstract T unloadImpl();
}
