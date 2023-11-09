import java.awt.*;

public abstract class Cars implements Movable{

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected double x;
    protected double y;
    protected String[] directions={"NORTH", "EAST", "SOUTH", "WEST"}; // ta bort om den inte används
    protected int direction;

    protected Cars(int carNrDoors, double carEnginePower, Color carColor, String carModelName){
        nrDoors = carNrDoors;
        enginePower = carEnginePower;
        color = carColor;
        modelName = carModelName;


        stopEngine();
    }

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }
    public static void main(String[] args) {

    }
    abstract public void incrementSpeed(double amount);
    abstract public void decrementSpeed(double amount);


    public void gas(double amount){
        if (amount <= 1 && amount >= 0){
            incrementSpeed(amount);
        }
        else{
            System.out.println("Amount outside Anders");
        }

    }
    protected void brake(double amount){
        if (amount <= 1 && amount >= 0){
            decrementSpeed(amount);
        }
        else{
            System.out.println("Amount outside range");
        }

    }

    @Override
    public void move() {
        System.out.println(directions[direction]);
        if (direction%2==0) {
            if (direction==0){
                y=y+currentSpeed;
            }
            else {
                y=y-currentSpeed;
            }
        }
        else {
            if (direction==1){
                x=x+currentSpeed;
            }
            else {
                x=x-currentSpeed;
            }
        }

        System.out.println("X: "+x);
        System.out.println("Y: "+y);
    }

    @Override
    public void turnLeft() {
        direction= direction-1;
        if (direction<0){
            direction=direction+4;
        }

    }

    @Override
    public void turnRight() {
        direction= direction+1;
        if (direction>3){
            direction=direction-4;
        }
    }
}
