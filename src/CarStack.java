import java.util.Iterator;
import java.util.Stack;

public class CarStack implements Iterable<Car>{
    private final int maxCars;
    private final int maxDoors;
    private final Stack<Car> cars = new Stack<>();

    public CarStack(int maxCars, int maxDoors){
        this.maxCars = maxCars;
        this.maxDoors = maxDoors;
    }

    public void addCar(Car car) {
        if((cars.size() < maxCars) && (car.getNrDoors() <= maxDoors) && !cars.contains(car)) {
            cars.push(car);
        }
    }

    public Car removeCar() {
        if (!cars.isEmpty()) return cars.pop();
        return null;
    }

    public int getNrOfLoadedCars() {
        return cars.size();
    }

    public boolean isCarLoaded(Car car) {
        return cars.contains(car);
    }

    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public void move() {
        for (Car car: cars) {
            car.move();
        }
    }

    public void turnLeft() {
        for (Car car: cars) {
           car.turnLeft();
        }
    }

    public void turnRight() {
        for(Car car: cars) {
            car.turnRight();
        }
    }
}
