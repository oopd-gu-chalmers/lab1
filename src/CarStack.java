import java.util.Stack;

public class CarStack extends Stack {
    private int maxCars;
    public CarStack(int maxCars){
        this.maxCars = maxCars;
    }
    public void addCar(Car car) {
        if(this.size() <= maxCars) {
            this.push(car);
        }
    }

    public Car removeCar() {
        if (this.size() > 0) return (Car) this.pop();
        return null;
    }
}
