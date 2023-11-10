import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Cars implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private final Point2D position;
    public Direction direction;


    public Cars(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = new Point2D.Double(0.0F, 0.0F);
        this.direction = Direction.NORTH;

    }

    public void gas(double amount) {

        if (0.0D <= amount && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void Break(double amount) {
        if (0.0D <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    public abstract double speedFactor();


    private double currentSpeed; // The current speed of the car

    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public void move() {
        switch (this.direction) {
            case NORTH:
                this.position.setLocation(this.position.getX(), (this.position.getY() + getCurrentSpeed())); break;
            case EAST:
                this.position.setLocation((this.position.getX() + getCurrentSpeed()), this.position.getY()); break;
            case SOUTH:
                this.position.setLocation(this.position.getX(), (this.position.getY() - getCurrentSpeed())); break;
            case WEST:
                this.position.setLocation((this.position.getX() - getCurrentSpeed()), this.position.getY()); break;
        }
    }

    public void turnLeft() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.WEST; break;
            case WEST:
                this.direction = Direction.SOUTH; break;
            case SOUTH:
                this.direction = Direction.EAST; break;
            case EAST:
                this.direction = Direction.NORTH; break;
        }
    }

    public void turnRight() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.EAST; break;
            case EAST:
                this.direction = Direction.SOUTH; break;
            case SOUTH:
                this.direction = Direction.WEST; break;
            case WEST:
                this.direction = Direction.NORTH; break;
        }

    }
    public double getPositionX() {return this.position.getX();
    }

    public double getPositionY() {return this.position.getY();
    }


    public void setCurrentSpeed(double amount) {this.currentSpeed = amount;}

    public int getNrDoors() {return nrDoors;}

    public double getEnginePower() {return enginePower;}

    public double getCurrentSpeed() {return currentSpeed;}

    public Color getColor() {return color;}

    public void setColor(Color clr) {color = clr;}

    public String getModelName() {return modelName;}

    public void startEngine() {currentSpeed = 0.1;}

    public void stopEngine() {currentSpeed = 0;}

    public void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min((getCurrentSpeed() + speedFactor() * amount), getEnginePower()));
    }   // Current speed not set

    public void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max((getCurrentSpeed() - speedFactor() * amount), 0));
    }
}
