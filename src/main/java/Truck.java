import java.awt.*;
import java.awt.geom.Point2D;

public class Truck implements ITruck, Movable {
    private final Vehicle vehicle;

    public Truck(Color color, double enginePower, String modelName, int nrOfDoors) {
        this.vehicle = new Vehicle(color, enginePower, modelName, nrOfDoors);
    }

    @Override
    public int getNrDoors() {
        return vehicle.getNrDoors();
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
    public Direction getDirection() {
        return vehicle.getDirection();
    }

    @Override
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
        gas(amount, 1);
    }

    public void gas(double amount, double speedFactor) {
        vehicle.gas(amount, speedFactor);
    }

    @Override
    public void brake(double amount) {
        brake(amount, 1);
    }

    public void brake(double amount, double speedFactor) {
        vehicle.brake(amount, speedFactor);
    }

    @Override
    public boolean engineIsRunning() {
        return vehicle.engineIsRunning();
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
}