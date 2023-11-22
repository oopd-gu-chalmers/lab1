import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 implements ICar {
    private final Car car;
    public final static double trimFactor = 1.25;

    public Volvo240() {
        car = new Car(Color.BLACK, 100, "Volvo240", 4, UnitSize.SMALL_CAR_UNIT_SIZE);
        stopEngine();
    }

    @Override
    public int getNrDoors() {
        return car.getNrDoors();
    }

    @Override
    public double getEnginePower() {
        return car.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return car.getColor();
    }

    @Override
    public void setColor(Color clr) {
        car.setColor(clr);
    }

    @Override
    public String getModelName() {
        return car.getModelName();
    }

    @Override
    public void startEngine() {
        car.startEngine();
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    private double speedFactor() {
        return car.getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public boolean engineIsRunning() {
        return car.engineIsRunning();
    }

    @Override
    public void gas(double amount) {
        car.gas(amount, speedFactor());
    }

    @Override
    public void brake(double amount) {
        car.brake(amount, speedFactor());
    }

    @Override
    public int getUnitSize() {
        return car.getUnitSize();
    }

    @Override
    public boolean isLoaded() {
        return car.isLoaded();
    }

    @Override
    public Point2D.Double getPosition() {
        return car.getPosition();
    }

    @Override
    public void setPositionToLoaderPosition(Point2D.Double loaderPosition) {
        car.setPositionToLoaderPosition(loaderPosition);
    }

    @Override
    public void move() {
        car.move();
    }

    @Override
    public void turnRight() {
        car.turnRight();
    }

    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    @Override
    public Direction getDirection() {
        return car.getDirection();
    }
}