import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransporter extends Vehicle{

    private BedComponent bedComponent;
    private LoadComponent loadComponent;

    public CarTransporter(int nrDoors, double enginePower, Color color, String modelName, int loadCapacity){
        super(nrDoors, enginePower, color, modelName);
        this.bedComponent = new BedComponent();
        this.loadComponent = new LoadComponent(loadCapacity);
    }

    protected double speedFactor(){
        return 5;
    }

    protected boolean isBedUp(){
        return this.bedComponent.isBedUp();
    }

    protected void setBedState(boolean newState){
        this.bedComponent.setBedState(newState, getCurrentSpeed());
    }

    protected int getLoadCapacity(){
        return this.loadComponent.getLoadCapacity();
    }


    @Override
    public void move() {
        if (isBedUp()) {
            super.move();
            ArrayList<Vehicle> carList = new ArrayList<>(loadComponent.getCarStack());
            for (int i = 0; i < carList.size(); i++) {
                carList.get(i).setPosition(this.getPosition()); //the carTransporters position should already be changed from super.move()
            }
        }
        else {
            throw new IllegalArgumentException("CarTransporter cannot move if Bed is down.");
        }
    }
    public void load(Vehicle car) {
        loadComponent.load((car), isBedUp(),getPosition(), distanceToCar(car), car.getEnginePower());
    }
    public void unload() {
        Vehicle car = loadComponent.unload(isBedUp(), getPosition());
        if (car == null) {
            throw new IllegalArgumentException("Unable to unload the car");
        }
    }


    protected double distanceToCar(Vehicle car){
        Point currentPosition = this.getPosition();
        Point otherPosition = car.getPosition();

        return currentPosition.distance(otherPosition);
    }

}
