import java.awt.*;

public abstract class Car implements Movable {
    protected double[] position = {0, 0};
    protected double[] direction = {0, 1};
    protected  int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
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

    //Är det meningen att vi ska ha massa abstrakta methods här?
    public abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    public void gas(double amount) {
        if ((amount >= 0) && (amount <= 1)) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if ((amount >= 0) && (amount <= 1)) {
            decrementSpeed(amount);
        }
    }

    /*Se till att era bilar implementerar interfacet Movable, med någon lämplig intern representation
    av deras riktning och position. Metoden move ska fungera så att beroende på riktning ökas
    (eller minskas) bilens x- eller y-koordinat med dess currentSpeed.*/

    public void move() {
        //Ändrar x eller y baserat på riktning
        position[0] = position[0] + currentSpeed*direction[0];
        position[1] = position[1] + currentSpeed*direction[1];
    }
    public void turnLeft() {
        //Ändrar riktning
        double x = direction[0];
        double y = direction[1];
        direction[0] = -y;
        direction[1] = x;
    }
    public void turnRight() {
        //Ändrar riktning
        double x = direction[0];
        double y = direction[1];
        direction[0] = y;
        direction[1] = -x;
    }
}
