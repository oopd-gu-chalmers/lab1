import java.util.Arrays;

public class MercedesCarTransport{
    private final Truck truck = new Truck();
    private final CarStack cars;

    public MercedesCarTransport(int maxCars, int maxDoors) {
        modelName = "Mercedes";
        cars = new CarStack(maxCars, maxDoors);
    }

    public void addCar(Car car) {
        if (!backIsOpen && Arrays.equals(car.position, new double[]{this.position[0] - this.getDirection()[0],
                this.position[1] - this.getDirection()[1]})) {
            cars.addCar(car);
        }
    }

    public Car removeCar() {
        Car car = cars.removeCar();
        car.position = new double[]{this.position[0] - this.getDirection()[0],
                                    this.position[1] - this.getDirection()[1]};
        return car;
    }

    public void raiseBack() {
        backIsOpen = false;
    }

    public void lowerBack() {
        if (currentSpeed == 0) {
            backIsOpen = true;
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
