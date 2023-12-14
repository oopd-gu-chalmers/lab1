import java.util.Vector;



public class Workshop<CarBrand extends Car> {
    private final int maxCars;
    public Vector<CarBrand> cars = new Vector<>();

    public Workshop(int maxCars) {
        this.maxCars = maxCars;
    }

    public void addCar(CarBrand car) {
        if (cars.size() < maxCars && !cars.contains(car))
            cars.add(car);
    }

    public void removeCar(CarBrand car) {
        cars.remove(car);
    }
}
