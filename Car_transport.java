import java.awt.*;
import java.util.Stack;

public class Car_transport extends Truck{

    private int capacity;

    private Stack<Car> cargo;

    public Car_transport(int nrDoors, Color color, double enginePower, String modelName, int capacity){
        super(nrDoors, color, enginePower, modelName);
        this.capacity = capacity;
    }

    public void pivotUp(){
        set_platformAngle(70);
    }

    public void pivotDown(){
        if (getCurrentSpeed() == 0){
            set_platformAngle(0);
        } else {
            System.out.println("Cannot lower ramp while driving");
        }

    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * ((double) (capacity - cargo.size() + 1) / capacity);
    }

    public void load_cargo(Car car){
        if (get_platformAngle() == 0 && cargo.size() < capacity) {
            cargo.push(car);
        } else {
            System.out.println("Unable to load cargo now");
        }
    }

    public void unload_cargo(){
        if (get_platformAngle() == 0 ) {
            cargo.pop();
        } else {
            System.out.println("Unable to unload cargo now");
        }
    }

}
