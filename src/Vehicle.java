public class Vehicle<T extends Movable & Engine & HasName> {
    public T vehicle;
    public Vehicle(T vehicle) {
        this.vehicle = vehicle;
    }

    public void setPosition(double[] position) {
        vehicle.setPosition(position);
    }
    public double[] getPosition() {
        return vehicle.getPosition();
    }
    public void setCurrentSpeed(double currentSpeed) {
        vehicle.setCurrentSpeed(currentSpeed);
    }
    public double getCurrentSpeed() {
        return vehicle.getCurrentSpeed();
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
    public void gas(double amount) {
        vehicle.gas(amount);
    }
    public void brake(double amount) {
        vehicle.brake(amount);
    }
    public String getName() {
        return vehicle.getName();
    }
}
