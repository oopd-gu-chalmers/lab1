public class Vehicle2<T extends Movable & Engine> {
    public T vehicle;
    public Vehicle2(T vehicle) {
        this.vehicle = vehicle;
    }
    public void move() {
        vehicle.move();
    }
    public void turnLeft() {
        vehicle.turnLeft();
    }
    public void turnRight() {
        vehicle.turnRight();
    }
    public void startEngine() {
        vehicle.startEngine();
    }
    public void stopEngine() {
        vehicle.stopEngine();
    }
    public void gas() {
        vehicle.gas();
    }
    public void brake() {
        vehicle.brake();
    }
}
