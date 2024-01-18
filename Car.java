import java.awt.*;

abstract class Car implements Movable {

    private int nrDoors; //nbr of doors on the car
    private double enginePower; //engine power of the car
    private double currentSpeed; //current speed of the car
    private Color color; //color of the car
    String modelName; //car model name

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors =nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
        /* Dessa sparar vi till senare
        this.point = new Point (0,0);
        this.direction = 0;
         */
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
    abstract double speedfactor();
    public void incrementSpeed (double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedfactor() * amount, enginePower);
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedfactor() * amount, 0);
    }
    public void gas(double amount){
        if (amount >= 0 && amount <=1){
           incrementSpeed(amount);
        }
    }
    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }
    @Override
    public void move(){

    }
    @Override
    public void turnLeft(){

    }
    @Override
    public void turnRight(){

    }
}
