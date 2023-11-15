import java.util.Stack;

public class MercedesCarTransport extends Truck {
    private CarStack cars;

    public MercedesCarTransport(int maxCars) {
        cars = new CarStack(maxCars);
    }

    public void addCar() {
        if (!backIsClosed) {
            //cars.add();
        }
    }

    public Car removeCar() {
        Car car = cars.removeCar();
        car.position = this.position;
    }

    public void raiseBack() {
        backIsClosed = true;
    }

    public void lowerBack() {
        if (currentSpeed == 0) {
            backIsClosed = false;
        }
    }
}