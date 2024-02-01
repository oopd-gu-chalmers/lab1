import java.awt.*;

abstract class Vehicle implements Movable {
    private int nrDoors; //nbr of doors on the vehicle
    private double enginePower; //engine power of the vehicle
    private double currentSpeed; //current speed of the vehicle
    private Color color; //color of the vehicle
    private String modelName; //vehicle model name
    private Point position; // position
    //private double[] size; //size of the vehicle
    private double direction;

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName)//, double length, double width)
    {
        this.nrDoors =nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.position = new Point(0,0);
        //this.size = new double[]{length, width};
        this.direction = 0;
        stopEngine();

    }

    // Getters
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
    public String getModelName() {return modelName;}
    public Point getPosition() {return position; }
    //public double[] getSize() {return size; }
    public double getXPosition(){return position.getX();}
    public double getYPosition(){return position.getY();}
    public double getDirection(){return direction;}

    // Setters
    public void setColor(Color color) {
        this.color = color;
    }
    public void setPosition(Point position) {this.position = position;}

    // Actions
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
        } else {throw new IllegalArgumentException("Gas must be between 0 and 1");}
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Brake must be between 0 and 1");
        }
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
