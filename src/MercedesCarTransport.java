import java.util.Stack;

public class MercedesCarTransport extends Car implements Back{
    private boolean rampIsRaised = true;
    private Stack cars;
    private int maxCars;

    public MercedesCarTransport(int maxCars) {
        this.maxCars = maxCars;
    }

    public void addCar() {
        if (!rampIsRaised) {

        }
    }

    public void removeCar() {

    }

    public void raiseBack() {

        rampIsRaised = true;
    }

    public void lowerBack() {
        if (currentSpeed == 0) {
            rampIsRaised = false;
        }
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}