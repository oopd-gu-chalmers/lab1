import java.awt.*;
import java.awt.geom.Point2D;

public class Vehicle implements IVehicle, Movable {
    private Color color;
    private final double enginePower;
    private double currentSpeed;
    private final String modelName;
    private boolean engineIsRunning;
    private Direction direction;
    private Point2D.Double position;
    private final int nrOfDoors;

    public Vehicle(Color color, double enginePower, String modelName, int nrOfDoors) {
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.nrOfDoors = nrOfDoors;
        this.currentSpeed = 0;
        this.direction = Direction.NORTH;
        this.position = new Point2D.Double(0, 0);
        stopEngine();
    }

    @Override
    public double getEnginePower() {
        return enginePower;
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    void setCurrentSpeed(double speed) {
        currentSpeed = Math.max(Math.min(speed, getEnginePower()), 0);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color clr) {
        color = clr;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Point2D.Double getPosition() {
        return position;
    }

    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    @Override
    public void startEngine() {
        setCurrentSpeed(0.1);
        engineIsRunning = true;
    }

    @Override
    public void stopEngine() {
        setCurrentSpeed(0);
        engineIsRunning = false;
    }

    @Override
    public void gas(double amount) {
        gas(amount, 1);
    }

    public void gas(double amount, double speedFactor) {
        incrementSpeed(amount, speedFactor);
    }

    @Override
    public void brake(double amount) {
        brake(amount, 1);
    }

    public void brake(double amount, double speedFactor) {
        decrementSpeed(amount, speedFactor);
    }

    @Override
    public boolean engineIsRunning() {
        return engineIsRunning;
    }

    @Override
    public int getNrDoors() {
        return nrOfDoors;
    }

    private void incrementSpeed(double amount, double speedFactor) {
        alterSpeed(amount, speedFactor, true);
    }

    private void decrementSpeed(double amount, double speedFactor) {
        alterSpeed(amount, speedFactor, false);
    }

    private void alterSpeed(double amount, double speedFactor, boolean increment) {
        if (speedFactor < 0) {
            throw new IllegalArgumentException("speedFactor must be positive");
        }
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount must not be less than 0 or greater than 1");
        }
        double deltaSpeed = amount * speedFactor * (increment ? 1 : -1);
        setCurrentSpeed(getCurrentSpeed() + deltaSpeed);
    }

    @Override
    public void move() {
        setPosition(getNextPosition());
    }

    private Point2D.Double getNextPosition() {
        Point2D.Double unitDirectionPoint = getDirection().getUnitDirectionPoint();
        double deltaX = unitDirectionPoint.getX() * getCurrentSpeed();
        double deltaY = unitDirectionPoint.getY() * getCurrentSpeed();
        return new Point2D.Double(getPosition().getX() + deltaX, getPosition().getY() + deltaY);
    }

    @Override
    public void turnRight() {
        setDirection(getDirection().getNext());
    }

    @Override
    public void turnLeft() {
        setDirection(getDirection().getPrevious());
    }
}