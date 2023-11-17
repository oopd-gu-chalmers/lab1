import java.awt.*;
import java.awt.geom.Point2D;

public class Vehicle implements IVehicle, Movable {
    private Color color;
    private double enginePower;
    private double currentSpeed;
    private String modelName;
    private boolean engineIsRunning;
    private Direction direction;
    private Point2D.Double position;
    private int nrOfDoors;

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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

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
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount must not be less than 0 or greater than 1");
        }
        incrementSpeed(amount, 1);
    }

    @Override
    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount must not be less than 0 or greater than 1");
        }
        decrementSpeed(amount, 1);
    }

    @Override
    public boolean engineIsRunning() {
        return engineIsRunning;
    }

    @Override
    public int getNrDoors() {
        return nrOfDoors;
    }

    public void incrementSpeed(double amount, double speedFactor) {
        if (speedFactor < 0) {
            throw new IllegalArgumentException("speedFactor must be positive");
        }
        setCurrentSpeed(getCurrentSpeed() + amount * speedFactor);
    }

    public void decrementSpeed(double amount, double speedFactor) {
        if (speedFactor < 0) {
            throw new IllegalArgumentException("speedFactor must be positive");
        }
        setCurrentSpeed(getCurrentSpeed() - amount * speedFactor);
    }

    @Override
    public void move() {
        setPosition(getNextPosition());
    }

    Point2D.Double getNextPosition() {
        return switch (direction) {
            case Direction.NORTH -> new Point2D.Double(getPosition().x, getPosition().y + getCurrentSpeed());
            case Direction.EAST -> new Point2D.Double(getPosition().x + getCurrentSpeed(), getPosition().y);
            case Direction.SOUTH -> new Point2D.Double(getPosition().x, getPosition().y - getCurrentSpeed());
            case Direction.WEST -> new Point2D.Double(getPosition().x - getCurrentSpeed(), getPosition().y);
        };
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