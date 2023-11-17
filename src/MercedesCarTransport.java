import java.util.Arrays;

public class MercedesCarTransport extends Truck {
    private final CarStack cars;

    public MercedesCarTransport(int maxCars, int maxDoors) {
        super();
        cars = new CarStack(maxCars, maxDoors);
    }

    public void addCar(Car car) {
        if (!backIsClosed && Arrays.equals(car.position, new double[]{this.position[0] - this.getDirection()[0],
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
        backIsClosed = true;
    }

    public void lowerBack() {
        if (currentSpeed == 0) {
            backIsClosed = false;
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
