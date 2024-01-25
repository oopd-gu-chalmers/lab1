import java.awt.*;
import java.util.Stack;


public class CarTransport extends Car {
    private boolean rampUp;
    private Stack<Car> loadedCars;
    private int maxCars;
    private double[] maxSize;
    private static final int maxCarDistance = 5;


    // Constructor
    public CarTransport(int maxCars, double[] maxSize) {
        // Call the superclass constructor with dummy values for length and width
        super(2, Color.gray, 600, "CarTransport", 0, 0);
        this.rampUp = true;
        this.loadedCars = new Stack<>();
        this.maxCars = maxCars;
        this.maxSize = maxSize;
    }

    

    // Actions
    public void raiseRamp() {
        validateRampOperation();
        rampUp = true;
    }

    public void lowerRamp() {
        validateRampOperation();
        rampUp = false;
    }

    public void loadCar(Car car) {

        validateNotTransporter(car);
        validateCarLoaded(car);
        validateRampState();
        validateTransporterState();
        validateCarPosition(car);
        validateMaxCars();
        validateCarSize(car);

        loadedCars.push(car);
        car.setPosition(getPosition()); // Set the car's position to be the same as the transporter
    }

    public void unloadCar() {

        validateTransporterState();
        validateRampState();
        validateTransporterEmpty();

        Car lastLoadedCar = loadedCars.pop();
        setCarPositionABitOff(lastLoadedCar);
    }

    @Override
    double speedFactor() {
        return 0;
    }

    @Override
    public void move(){
        super.move();
        for (Car car : loadedCars) {
            car.setPosition(getPosition());
        }
    }






    // Getters
    public boolean isRampUp() {
        return rampUp;
    }
    private boolean isCarWithinRange(Car car, double range) {             // Is the car within range of the transporter?
        Point carPosition = car.getPosition();
        Point transporterPosition = getPosition();
        return carPosition.distance(transporterPosition) <= range;
    }
    private boolean isCarSizeValid(Car car){                                // Is the car small enough to be loaded?
        double[] carSize = car.getSize();
        return carSize[0] <= maxSize[0] && carSize[1] <= maxSize[1];
    }







    // Validation methods
    public void validateRampOperation() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException("Cannot operate ramp when transporter is non-stationary!");
        }
    }

    private void validateCarPosition(Car car) {
        if (!isCarWithinRange(car, maxCarDistance)) {
            throw new IllegalArgumentException("Car is not within range, please move closer to the transporter!");
        }
    }

    private void validateCarSize(Car car) {
        if (!isCarSizeValid(car)) {
            throw new IllegalArgumentException("Car is too big for transporter and cannot be loaded!");
        }
    }

    private void validateMaxCars() {
        if (loadedCars.size() >= maxCars) {
            throw new IllegalStateException("Transporter is full, cannot load car!");
        }
    }

    private void validateRampState() {
        if (rampUp) {
            throw new IllegalStateException("Cannot load or unload car when ramp is up!");
        }
    }

    private void validateCarLoaded(Car car) {
        if (loadedCars.contains(car)) {
            throw new IllegalStateException("Car is already loaded!");
        }
    }

    private void validateTransporterState() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException("Cannot load or unload car when transporter is moving!");
        }
    }

    private void validateNotTransporter(Car car) {
        if (car instanceof CarTransport) {
            throw new IllegalStateException("Cannot load a transporter onto another transporter!");
        }
    }

    private void validateTransporterEmpty() {
        if (loadedCars.isEmpty()) {
            throw new IllegalStateException("Transporter is empty!");
        }
    }



    
    // Helper methods
    private void setCarPositionABitOff(Car car) {
        Point transporterPosition = getPosition();
        double newX = transporterPosition.getX() + 10; // Adjust as needed
        double newY = transporterPosition.getY() + 10; // Adjust as needed
        Point newPoint = new Point((int)newX, (int)newY);
        car.setPosition(newPoint);
    }
}

