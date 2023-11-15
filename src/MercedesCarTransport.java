import java.util.Stack;

public class MercedesCarTransport extends Car{
    private boolean rampIsRaised = true;
    private Stack cars;
    private int maxCars;

    public MercedesCarTransport(int maxCars) {
        this.maxCars = maxCars;
    }

    public void addCar() {

    }

    public void removeCar() {

    }

    @Override
    public double speedFactor() {
        return 0;
    }
}