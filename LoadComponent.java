import java.util.Stack;
import java.awt.Point;

public class LoadComponent {
    private Stack<Vehicle> carStack;
    private int loadCapacity;

    public LoadComponent(int capacity) {
        if (capacity > 0 && capacity <= 20) {
            this.loadCapacity = capacity;
            this.carStack = new Stack<>();
        }
        else {
            throw new IllegalArgumentException("Invalid load capacity");
        }
    }

    public void load(Vehicle car, boolean bedUp, Point transporterPosition, double distanceToCar, double enginePower) {
        if (car instanceof CarTransporter) {
            throw new IllegalArgumentException("Cannot transport another carTransporter");
        } else if (carStack.size() >= loadCapacity) {
            throw new IllegalArgumentException("carTransporter is full");
        } else if (bedUp) {
            throw new IllegalArgumentException("Can't load a car when bed is up");
        } else if (carStack.contains(car)) {
            throw new IllegalArgumentException("The transport already contains the car");}
        else if (distanceToCar > 5) {
            throw new IllegalArgumentException("Distance to the car too big");
        }
        else if (car.getEnginePower() > 400) { //We determine wheter a car is too big or not based on its engine power (400 max).
            throw new IllegalArgumentException("car is too big");
        }
        else {
            car.setPosition(transporterPosition); // Update the car's position
            carStack.push(car);
        }
    }

    public Vehicle unload(boolean bedUp, Point transporterPosition) {
        if (!bedUp && !carStack.isEmpty()) {
            Vehicle car = carStack.pop();
            // Position the car near the transporter
            Point newPosition = new Point(
                    (int) (transporterPosition.getX() + 2),
                    (int) (transporterPosition.getY())
            );
            car.setPosition(newPosition);
            return car;
        }
        return null; // Unable to unload
    }

    public int getLoadCapacity() {
        return this.loadCapacity;
    }

    public Stack<Vehicle> getCarStack(){
        return this.carStack;
    }

}
