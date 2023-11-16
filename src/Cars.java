import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Cars implements Movable {
    private final int nrDoors;
    private final double enginePower;
    private final Color color;
    private final String modelName;
    private Direction direction;
    private Object position;


    public Cars(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = Direction.NORTH;
        this.position = new Object();
    }

    // TODO kanske skapa en ny kostruktor för lastbilar

    public void gas(double amount) {

        if (0.0D <= amount && amount <= 1) {
            incrementSpeed(amount);
        }

    }

    public void brake(double amount) {
        if (0.0D <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }
    public abstract double speedFactor();
    private double currentSpeed;
    private enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public void move() {
        switch (this.direction) {
            case NORTH:
                this.position.setPosition(this.position.getPositionX(), (this.position.getPositionY() + getCurrentSpeed())); break;
            case EAST:
                this.position.setPosition(this.position.getPositionX() + getCurrentSpeed(), this.position.getPositionY()); break;
            case SOUTH:
                this.position.setPosition(this.position.getPositionX(), (this.position.getPositionY() - getCurrentSpeed())); break;
            case WEST:
                this.position.setPosition(this.position.getPositionX() - getCurrentSpeed(), this.position.getPositionY()); break;
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


    public String getDirection(){
        return this.direction.name();
    }
    private void setCurrentSpeed(double amount) {this.currentSpeed = amount;}

    public int getNrDoors() {return nrDoors;}

    public double getEnginePower() {return enginePower;}

    public double getCurrentSpeed() {return currentSpeed;}

    public Color getColor() {return color;}

    //private void setColor(Color clr) {color = clr;}

    public String getModelName() {return modelName;}

    public void startEngine() {currentSpeed = 0.1;}

    public void stopEngine() {currentSpeed = 0;}

    private void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min((getCurrentSpeed() + speedFactor() * amount), getEnginePower()));
    }

    private void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max((getCurrentSpeed() - speedFactor() * amount), 0));
    }

}
