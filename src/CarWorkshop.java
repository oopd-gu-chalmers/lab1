import java.util.Vector;
public class CarWorkshop {
    private Vector cars;

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

}
