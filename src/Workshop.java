import java.util.Vector;



public class Workshop<C> {
    private final int maxCars;
    public Vector<C> cars = new Vector<>();

    public Workshop(int maxCars) {
        this.maxCars = maxCars;
    }

    public void addCar(C car) {
        if (cars.size() < maxCars)
            cars.add(car);
    }

    public void removeCar(C car) {
        cars.remove(car);
    }
}
