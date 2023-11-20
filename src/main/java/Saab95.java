import java.awt.*;
import java.awt.geom.Point2D;

public class Saab95 implements ICar, Movable, Loadable {
    public boolean turboOn;
    private final Car car;
    private CanLoad loader;
    private final int unitSize;

    public Saab95() {
        car = new Car(Color.RED, 125, "Saab95", 2);
        turboOn = false;
        loader = null;
        unitSize = UnitSize.SMALL_CAR_UNIT_SIZE;
        car.stopEngine();
    }

    public int getNrDoors() {
        return car.getNrDoors();
    }

    public double getEnginePower() {
        return car.getEnginePower();
    }

    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    public Color getColor() {
        return car.getColor();
    }

    public void setColor(Color clr) {
        car.setColor(clr);
    }

    @Override
    public String getModelName() {
        return car.getModelName();
    }

    public void startEngine() {
        car.startEngine();
    }

    public void stopEngine() {
        car.stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    private double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return car.getEnginePower() * 0.01 * turbo;
    }

    @Override
    public boolean engineIsRunning() {
        return car.engineIsRunning();
    }

    public void gas(double amount) {
        car.incrementSpeed(amount, speedFactor());
    }

    public void brake(double amount) {
        car.decrementSpeed(amount, speedFactor());
    }

    @Override
    public int getUnitSize() {
        return unitSize;
    }

    @Override
    public boolean isLoaded() {
        return loader != null;
    }

    @Override
    public void load(CanLoad loader) {
        setLoader(loader);
    }

    @Override
    public void unload(Point2D.Double unloadingPosition) {
        car.setPosition(unloadingPosition);
        setLoader(null);
    }

    public void setLoader(CanLoad loader) {
        this.loader = loader;
    }

    @Override
    public CanLoad getLoader() {
        return loader;
    }

    @Override
    public Point2D.Double getPosition() {
        return car.getPosition();
    }

    @Override
    public void updatePosition(Point2D.Double loaderPosition) {
        car.setPosition(loaderPosition);
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
