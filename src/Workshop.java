import java.util.Objects;
import java.util.Vector;



public class Workshop {
    private final int maxCars;
    private final String modelName;
    private Vector<Car> cars = new Vector<>();

    public Workshop(String modelName, int maxCars) {
        this.modelName = modelName;
        this.maxCars = maxCars;
    }

    public void addCar(Car car) {
        if (Objects.equals(car.modelName, this.modelName) && cars.size() < maxCars) {
            cars.add(car);
        }
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }
}
