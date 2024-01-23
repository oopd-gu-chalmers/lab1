import java.awt.*;
public abstract class Car implements Movable {
    //Common attributes
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected String modelName;
    protected Point position;
    protected double currentDirection;



    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Point position) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.position = position;

    }


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);

    public void move() {
        double deltaX = currentSpeed * Math.cos(Math.toRadians(currentDirection));
        double deltaY = currentSpeed * Math.sin(Math.toRadians(currentDirection));

        position.x += (int) deltaX;
        position.y += (int) deltaY;
    }
    public void turnLeft() {
        //Turn Upwards
        currentDirection += 90;
        if (currentDirection >= 360){
            currentDirection -= 360;
        }
    }
    public void turnRight() {
        //Turn Downwards
        currentDirection -=90;
        if (currentDirection < 0){
            currentDirection += 360;
        }

    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}




