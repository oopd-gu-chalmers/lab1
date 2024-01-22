import java.awt.*;
import java.awt.geom.Point2D;

abstract class Car implements Movable {

    private int nrDoors; //nbr of doors on the car
    private double enginePower; //engine power of the car
    private double currentSpeed; //current speed of the car
    private Color color; //color of the car
    String modelName; //car model name
    private Point2D position; // position
    private double direction;

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors =nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
        this.position = new Point2D.Double(0,0);
        this.direction = 0;

    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    abstract double speedFactor();
    public void incrementSpeed (double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    public void gas(double amount){
        if (amount >= 0 && amount <=1){
           incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
    public Point2D getPosition(){
        return position;
    }
    public double getXPosition(){
        return position.getX();
    }
    public double getYPosition(){
        return position.getY();
    }
    public double getDirection(){
        return direction;
    }
    @Override
    public void move(){
        position.setLocation(Math.cos(direction) * currentSpeed, Math.sin(direction) * currentSpeed);

        //position.setLocation(Math.cos(direction) + currentSpeed, Math.sin(direction) + currentSpeed); Detta behövs nog inte
    }
    @Override
    public void turnLeft(){
        direction += Math.PI/4;
    }
    @Override
    public void turnRight(){
        direction -= Math.PI/4  ;
    }
}
