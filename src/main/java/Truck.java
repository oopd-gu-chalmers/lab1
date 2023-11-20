import java.awt.*;
import java.awt.geom.Point2D;

public class Truck implements ITruck, Movable {
    private final Vehicle vehicle;

    public Truck(Color color, double enginePower, String modelName, int nrOfDoors) {
        this.vehicle = new Vehicle(color, enginePower, modelName, nrOfDoors);
    }

    @Override
    public double getEnginePower() {
        return vehicle.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return vehicle.getCurrentSpeed();
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
        vehicle.incrementSpeed(amount, 1);
    }

    @Override
    public void brake(double amount) {
        vehicle.decrementSpeed(amount, 1);
    }

    @Override
    public boolean engineIsRunning() {
        return vehicle.engineIsRunning();
    }

    @Override
    public int getNrDoors() {
        return vehicle.getNrDoors();
    }

    @Override
    public void move() {
        vehicle.move();
    }

    @Override
    public void turnRight() {
        vehicle.turnRight();
    }

    @Override
    public void turnLeft() {
        vehicle.turnLeft();
    }

    @Override
    public Direction getDirection() {
        return vehicle.getDirection();
    }

    @Override
    public Point2D.Double getPosition() {
        return vehicle.getPosition();
    }
}