import java.awt.*;
import java.util.Stack;


public class CarTransport extends Vehicle implements Platform{
    private StackLoader<Car> loadedCars;
    private boolean rampUp;



    // Constructor
    public CarTransport() {
        super(2, Color.gray, 600, "CarTransport","pics/CarTransport.jpg");
        this.rampUp = true;
        loadedCars = new StackLoader<>(5);


    }

    public boolean getRampState(){
        return rampUp;
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
        loadedCars.validateCarPosition(car, getPosition());
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



    // Validation methods
    public void validateRampOperation() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException("Cannot operate ramp when transporter is non-stationary!");
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




    // Helper methods
    private void setCarPositionABitOff(Car car) {
        Point transporterPosition = getPosition();
        double newX = transporterPosition.getX() + 10; // Adjust as needed
        double newY = transporterPosition.getY() + 10; // Adjust as needed
        Point newPoint = new Point((int)newX, (int)newY);
        car.setPosition(newPoint);
    }
}

