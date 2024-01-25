package src;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    private final String modelName; // The car model name
    public Point2D point;
    public Point direction;
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Point2D point, Point direction){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.point = point;
        this.direction = direction;
    } // Använda this. eller inte?

    public int getNrDoors() {
        return this.nrDoors;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public void startEngine() {
        this.currentSpeed = 0.1;
    }

    public void stopEngine() {
        this.currentSpeed = 0;
    }

    @Override
    public void move() {
        this.point =  new Point2D.Double(this.point.getX() + this.direction.x*this.currentSpeed,
                this.point.getY()+this.direction.y*this.currentSpeed);
    }

    @Override
    public void turnLeft() { // can only look at oen of the four vädersträck
        int tmp = this.direction.x;
        this.direction.x = - this.direction.y;
        this.direction.y = tmp;

    }

    @Override
    public void turnRight() {
        int tmp = this.direction.x;
        this.direction.x = this.direction.y;
        this.direction.y = -tmp;
    }
    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        this.currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }
    public void decrementSpeed(double amount){
        this.currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
}
}

