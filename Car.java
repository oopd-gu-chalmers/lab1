import java.awt.*;
import java.awt.geom.Point2D;

public class Car implements Moveable{
    // Attributes
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected Point2D.Double position; // Position of the car

    protected enum Direction {up, down, left, right}; // The current direction of the car
    protected Direction direction;

    // Methods:

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public String getModelName(){
        return modelName;
    }

    public Point2D.Double getPosition(){
        position = new Point2D.Double();
        return position;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void setPosition(double x, double y){
        position.x = x;
        position.y = y;
    }

    public void setDirection(Direction dir){
        direction = dir;
    }

    public Direction getDirection(){
        return direction;
    }

    @Override
    public void move() {
        if (getDirection() == Direction.up){
            position.y = position.y + currentSpeed;
        }
        if (getDirection() == Direction.down){
            position.y = position.y - currentSpeed;
        }
        if (getDirection() == Direction.left){
            position.x = position.x - currentSpeed;
        }

        if (getDirection() == Direction.right){
            position.x = position.x + currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        if (getDirection() == Direction.up){
            direction = Direction.left;
        }
        if (getDirection() == Direction.down){
            direction = Direction.right;
        }
        if (getDirection() == Direction.left){
            direction = Direction.down;
        }

        if (getDirection() == Direction.right){
            direction = Direction.up;
        }
    }

    @Override
    public void turnRight() {

    }
}
