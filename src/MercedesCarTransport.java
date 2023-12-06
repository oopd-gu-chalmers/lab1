import java.util.Arrays;

public class MercedesCarTransport{
    private final Truck truck = new Truck();
    private final CarStack cars;

    public MercedesCarTransport(int maxCars, int maxDoors) {
        truck.setModelName("Mercedes");
        cars = new CarStack(maxCars, maxDoors);
    }

    public void addCar(Car car) {
        if (!truck.getBackIsOpen() && Arrays.equals(car.position, new double[]{this.truck.getPosition()[0] - this.truck.getDirection()[0],
                this.truck.getPosition()[1] - this.truck.getDirection()[1]})) {
            cars.addCar(car);
        }
    }

    public Car removeCar() {
        Car car = cars.removeCar();
        car.position = new double[]{this.truck.getPosition()[0] - this.truck.getDirection()[0],
                                    this.truck.getPosition()[1] - this.truck.getDirection()[1]};
        return car;
    }

    public void raiseBack() {
        truck.setBackIsOpen(false);
    }

    public void lowerBack() {
        if (truck.getCurrentSpeed()==0) {
            truck.setBackIsOpen(true);
        }
    }
    
    @Override
    public void move() {
       super.move();
        for (Car car: cars) {
            car.setPosition(this.position);
        }
    }

    @Override
    public void turnLeft() {
        super.turnLeft();
        cars.turnLeft();
    }

    @Override
    public void turnRight() {
        super.turnRight();
        cars.turnRight();
    }
}
