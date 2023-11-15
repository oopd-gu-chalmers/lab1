import java.util.Stack;

public class MercedesCarTransport extends Truck {
    private Stack cars;
    private int maxCars;

    public MercedesCarTransport(int maxCars) {
        this.maxCars = maxCars;
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

    @Override
    public double speedFactor() {
        return 0;
    }
}