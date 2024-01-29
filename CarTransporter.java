import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransporter extends Car{

    private boolean bedUp; //hasBed?
    protected Stack<Car> carStack = new Stack<>(); //maybe should be public/private?
    private int loadCapacity;

    public CarTransporter(int nrDoors, double enginePower, Color color, String modelName, int loadCapacity){
        super(nrDoors, enginePower, color, modelName);
        this.bedUp = true;
        if (loadCapacity > 0 && loadCapacity <= 20 ) { //unreasonable for car transport with more than 20 cars.
            this.loadCapacity = loadCapacity;
        }
        else {
            throw new IllegalArgumentException("Invalid load capacity");
        }
    }

    protected double speedFactor(){
        return 5;
    }

    protected boolean getBedState(){
        return this.bedUp;
    }

    protected void setBedState(boolean newState){
        if (getCurrentSpeed() == 0){
            this.bedUp = newState;
        }
        else {
            throw new IllegalArgumentException("Stop to move the bed");
        }
    }

    protected int getLoadCapacity(){
        return this.loadCapacity;
    }

    protected void setLoadCapacity(int capacity){
        if (loadCapacity > 0 && loadCapacity <= 20 ){ //unreasonable for car transport with more than 20 cars.
            this.loadCapacity = capacity;
        }
        else {
            throw new IllegalArgumentException("Invalid load capacity");
        }
    }

    @Override
    public void move() {
        if (bedUp) {
            super.move();
            ArrayList<Car> carList = new ArrayList<>(carStack);
            for (int i = 0; i < carList.size(); i++) {
                carList.get(i).setPosition(this.getPosition()); //the carTransporters position should already be changed from super.move()
            }
        }
        else {
            throw new IllegalArgumentException("CarTransporter cannot move if Bed is down.");
        }
    }

    protected void load(Car car){ // Will have to add some functionality to check that it isn't carTransporter

        if (car instanceof CarTransporter) {
            throw new IllegalArgumentException("Cannot transport another carTransporter");
        }
        else if (carStack.size() >= getLoadCapacity()) {
            throw new IllegalArgumentException("carTransporter is full");
        }
        else if (bedUp) {
            throw new IllegalArgumentException("Can't load a car when bed is up");
        }
        else if (carStack.contains(car)) {
            throw new IllegalArgumentException("The transport already contains the car");
        }
        else if (distanceToCar(car) > 5) {
            throw new IllegalArgumentException("Distance to the car too big");
        }
        else if (car.getEnginePower() > 400) { //We determine wheter a car is too big or not based on its engine power (400 max).
            throw new IllegalArgumentException("carTransporter is full");
        }
        else {
            carStack.push(car); //lägg till bil i stacken
        }

    }

    protected void unload(Car car) {
        if (bedUp && carStack.contains(car)) {
            carStack.push(car);

            Point newPosition = new Point(
                    (int) (getPosition().getX() + 2),
                    (int) (getPosition().getY())
            );
            car.setPosition(newPosition);
        }
        else if (bedUp) {
                throw new IllegalArgumentException("Can't unload a car when bed is up");
        }
        else {
            throw new IllegalArgumentException("Distance to the car too big");
        }
    }

    protected double distanceToCar(Car car){
        Point currentPosition = this.getPosition();
        Point otherPosition = car.getPosition();

        return currentPosition.distance(otherPosition);
    }

}
