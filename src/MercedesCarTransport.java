import java.util.Stack;

public class MercedesCarTransport extends Truck {
    private CarStack cars;

    public MercedesCarTransport(int maxCars) {
        cars = new CarStack(maxCars);
    }

    public void addCar() {
        if (!backIsClosed) {

        }
    }

    public void removeCar() {

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