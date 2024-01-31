import java.util.Stack;


public class LoadComponent {
    private Stack<Vehicle> carStack;
    private int loadCapacity;

    public LoadComponent(int capacity) {
        if (capacity > 0 && capacity <= 50) {
            this.loadCapacity = capacity;
            this.carStack = new Stack<>();
        }
        else {
            throw new IllegalArgumentException("Invalid load capacity");
        }
    }

    public void load(Vehicle car) {
        carStack.push(car);
    }

    public Vehicle unload() {
        if (!carStack.empty()) {
            Vehicle car = carStack.pop();
            return car;
        }
        return null;

    }

    public int getLoadCapacity() {
        return this.loadCapacity;
    }

    public Stack<Vehicle> getCarStack(){
        return this.carStack;
    }

}
