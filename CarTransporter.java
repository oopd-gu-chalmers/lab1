import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransporter extends Vehicle{

    private BedComponent bedComponent;
    private LoadComponent<Vehicle> loadComponent; //TODO Change to car

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
            throw new IllegalArgumentException("CarTransporter cannot move if bed is down.");
        }
    }
    public void load(Vehicle car) {
        Point transporterPosition = getPosition();
        double distanceToCar = distanceToCar(car);

        if (car instanceof CarTransporter) { //TODO gör bil till en ny klass under vehicle och kontrollera så att vi endast får loada
            throw new IllegalArgumentException("Cannot transport another carTransporter");
        } else if (isBedUp()) {
            throw new IllegalArgumentException("Can't load a car when bed is up");
        } else if (distanceToCar > 5) {
            throw new IllegalArgumentException("Distance to the car too big");
        } else if (car.getEnginePower() > 400) {
            throw new IllegalArgumentException("car is too big");
        } else {
            car.setPosition(transporterPosition);
            loadComponent.load(car);
        }
    }

    public Vehicle unload() {
        boolean bedUp = isBedUp();

        if (!bedUp) {
            Vehicle car = loadComponent.unload();

            Point newPosition = new Point(
                    (int) (getPosition().getX() + 2),
                    (int) (getPosition().getY())
            );
            car.setPosition(newPosition);
            return car;

        }
        else {
            throw new IllegalArgumentException("Can't unload a car when bed is up");
        }
    }

    private double distanceToCar(Vehicle car){
        Point currentPosition = this.getPosition();
        Point otherPosition = car.getPosition();

        return currentPosition.distance(otherPosition);
    }

    public Stack<Vehicle> getCarStack(){
        return this.loadComponent.getCarStack();
    }

}
