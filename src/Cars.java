import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Cars implements Movable {
    private final int nrDoors;
    private final double enginePower;
    private final Color color;
    private final String modelName;
    private final Point2D position;
    private Direction direction;


    public Cars(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = new Point2D.Double(0.0D, 0.0D);
        this.direction = Direction.NORTH;

    }
    public Point2D getPosition(){
        return position;
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
