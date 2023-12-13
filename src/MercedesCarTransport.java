import java.util.Arrays;

public class MercedesCarTransport{
    private final Truck truck = new Truck();
    private final CarStack cars;

    public MercedesCarTransport(int maxCars, int maxDoors) {
        truck.setModelName("Mercedes");
        cars = new CarStack(maxCars, maxDoors);
    }

    public void addCar(Car car) {
        if (!truck.getBackIsOpen() && Arrays.equals(car.getPosition(), new double[]{this.truck.getPosition()[0] - this.truck.getDirection()[0],
                this.truck.getPosition()[1] - this.truck.getDirection()[1]})) {
            car.setPosition(truck.getPosition());
            car.setDirection(truck.getDirection());
            cars.addCar(car);
        }
    }

    public Car removeCar() {
        Car car = cars.removeCar();
        car.setPosition(new double[]{this.truck.getPosition()[0] - this.truck.getDirection()[0],
                                    this.truck.getPosition()[1] - this.truck.getDirection()[1]});
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

    public void move() {
       truck.move();
       cars.move();
    }

    public void turnLeft() {
        truck.turnLeft();
        cars.turnLeft();
    }

    public void turnRight() {
        truck.turnRight();
        cars.turnRight();
    }
}
