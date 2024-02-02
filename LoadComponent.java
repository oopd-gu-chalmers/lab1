import java.util.Stack;


public class LoadComponent <V> { // TODO använd parametrisk polymorfism KLAR
    private Stack<V> carStack;
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

    public void load(V car) { //TODO inför begränsing och ändra till V. KLAR
        if (carStack.size() >= loadCapacity) {
            throw new IllegalArgumentException("Load capacity is full");
        }
        carStack.push(car);
    }

    public V unload() { //TODO trow exception istället för att returna null. KLAR
        if (!carStack.empty()) {
            V car = carStack.pop();
            return car;
        }
        throw new IllegalArgumentException("Load capacity is empty");

    }

    public int getLoadCapacity() {
        return this.loadCapacity;
    }

    public Stack<V> getCarStack(){
        return this.carStack;
    }

}
