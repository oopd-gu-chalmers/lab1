import java.awt.*;
import java.awt.geom.Point2D;

public class Car implements ICar, Movable {
    private final Vehicle vehicle;
    private int nrOfDoors;

    public Car(Color color, int nrOfDoors, double enginePower, String modelName) {
        this.vehicle = new Vehicle(color, enginePower, modelName);
        this.nrOfDoors = nrOfDoors;
        this.vehicle = new Vehicle(color, enginePower, modelName, nrOfDoors);
    }

    @Override
    public int getNrDoors() {
        return nrOfDoors;
    }

    @Override
    public double getEnginePower() {
        return vehicle.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return vehicle.getCurrentSpeed();
    }

    private void setCurrentSpeed(double speed) {
        vehicle.setCurrentSpeed(speed);
    }

    @Override
    public Color getColor() {
        return vehicle.getColor();
    }

    @Override
    public void setColor(Color clr) {
        vehicle.setColor(clr);
    }

    @Override
    public String getModelName() {
        return vehicle.getModelName();
    }

    public Direction getDirection() {
        return vehicle.getDirection();
    }

    public void setDirection(Direction direction) {
        vehicle.setDirection(direction);
    }

    public Point2D.Double getPosition() {
        return vehicle.getPosition();
    }

    public void setPosition(Point2D.Double position) {
        vehicle.setPosition(position);
    }

    @Override
    public void startEngine() {
        vehicle.startEngine();
    }

    @Override
    public void stopEngine() {
        vehicle.stopEngine();
    }

    @Override
    public void gas(double amount) {
        vehicle.gas(amount);
    }

    @Override
    public void brake(double amount) {
        vehicle.brake(amount);
    }

    @Override
    public boolean engineIsRunning() {
        return vehicle.engineIsRunning();
    }

    public void incrementSpeed(double amount, double speedFactor) {
        vehicle.incrementSpeed(amount, speedFactor);
    }

    public void decrementSpeed(double amount, double speedFactor) {
        vehicle.decrementSpeed(amount, speedFactor);
    }

    @Override
    public void move() {
        vehicle.move();
    }

    private Point2D.Double getNextPosition() {
        return vehicle.getNextPosition();
    }

    @Override
    public void turnRight() {
        vehicle.turnRight();
    }

    @Override
    public void turnLeft() {
        vehicle.turnLeft();
    }
}
