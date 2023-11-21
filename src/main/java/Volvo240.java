import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 implements ICar, Movable, Loadable {
    private final Car car;
    public final static double trimFactor = 1.25;
    private CanLoad loader;
    private final int unitSize;

    public Volvo240() {
        car = new Car(Color.BLACK, 100, "Volvo240", 4);
        loader = null;
        unitSize = UnitSize.SMALL_CAR_UNIT_SIZE;
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

    // TODO fix this method according to lab pm
    @Override
    public void gas(double amount) {
        car.incrementSpeed(amount, speedFactor());
    }

    // TODO fix this method according to lab pm
    @Override
    public void brake(double amount) {
        car.decrementSpeed(amount, speedFactor());
    }

    @Override
    public boolean engineIsRunning() {
        return car.engineIsRunning();
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

    private void setLoader(CanLoad loader) {
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