import java.awt.*;
import java.util.Stack;


public class CarTransport extends Vehicle implements Platform{
    private StackLoader<Car> loadedCars;
    private boolean rampUp;
    private static final int maxCarDistance = 5;


    // Constructor
    public CarTransport() {
        super(2, Color.gray, 600, "CarTransport");
        this.rampUp = true;
        loadedCars = new StackLoader<>(5);


    }



    // Actions
    @Override
    public void startEngine() {
        if (rampUp) {
            super.startEngine();
        }
        else {
            throw new IllegalStateException("Cannot start engine when ramp is down!");
        }
    }
    @Override
    public void incrementSpeed(double amount){
        if (rampUp){
            super.incrementSpeed(amount);
        }
        else {
            throw new IllegalStateException("Cannot increase speed when ramp is down!");
        }
    }

    @Override
    double speedFactor() {
        return 0.1;
    }
    // Platform methods
    @Override
    public void raisePlatform() {
       validateRampOperation();
         rampUp = true;
    }
    @Override
    public void lowerPlatform() {
        validateRampOperation();
        rampUp = false;
    }
    // Loadable methods
    public void loadCar(Car car) {
        validateTransporterState();
        validateRampState();
        validateCarPosition(car);
        loadedCars.load(car);
        car.setPosition(getPosition());
    }

    public Car unloadCar() {
        validateTransporterState();
        validateRampState();
        for (Car car : loadedCars) {
            car.setPosition(getPosition());
        }
        Car unloadedCar = loadedCars.unload();
        setCarPositionABitOff(unloadedCar);
        return unloadedCar;
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


    private void validateRampState() {
        if (rampUp) {
            throw new IllegalStateException("Cannot load or unload car when ramp is up!");
        }
    }

/*    private void validateCarLoaded(Car car) {
        if (loadedCars.contains(car)) {
            throw new IllegalStateException("Car is already loaded!");
        }
    }*/

    private void validateTransporterState() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException("Cannot load or unload car when transporter is moving!");
        }
    }


/*    private void validateTransporterEmpty() {
        if (loadedCars.isEmpty()) {
            throw new IllegalStateException("Transporter is empty!");
        }
    }*/




    // Helper methods
    private void setCarPositionABitOff(Car car) {
        Point transporterPosition = getPosition();
        double newX = transporterPosition.getX() + 10; // Adjust as needed
        double newY = transporterPosition.getY() + 10; // Adjust as needed
        Point newPoint = new Point((int)newX, (int)newY);
        car.setPosition(newPoint);
    }
}

