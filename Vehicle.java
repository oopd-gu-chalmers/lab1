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
    private String imagePath;

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName, String imagePath)//, double length, double width)
    {
        this.nrDoors =nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.position = new Point(0,0);
        //this.size = new double[]{length, width};
        this.direction = 0;
        this.imagePath = imagePath;
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
    public String getImagePath(){return imagePath;}
    public String setImagePath(String path){return imagePath = path;}

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
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (newSpeed <= enginePower) {
            currentSpeed = newSpeed;
        } else {
            currentSpeed = enginePower;
        }
    }
    public void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (newSpeed >= 0) {
            currentSpeed = newSpeed;
        } else {
            currentSpeed = 0;
        }
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
        position.setLocation((position.getX() + Math.cos(direction) * currentSpeed), (position.getY() + Math.sin(direction) * currentSpeed));
        }


    @Override
    public void turnLeft(){
        direction += Math.PI/4;
    }
    @Override
    public void turnRight(){
        direction -= Math.PI/4  ;
    }

    @Override
    public void reverseDirection(){
        direction += Math.PI;
    }
}
