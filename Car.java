import java.awt.*;

public class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Point point;
    private Point currentDirection;
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Point point, Point currentDirection){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.point = point;
        this.currentDirection = currentDirection;
    } // Använda this. eller inte?

    public int getNrDoors() {
        return nrDoors;
    } // Använd this. eller inte?

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

    @Override
    public void move() {
        this.point.setLocation(
                this.point.x + this.currentDirection.x * this.currentSpeed,
                this.point.y + this.currentDirection.y * this.currentSpeed
        );
    }

    @Override
    public void turnLeft() { // can only look at oen of the four vädersträck
        int tmp = this.currentDirection.x;
        this.currentDirection.x = - this.currentDirection.y;
        this.currentDirection.y = tmp;

    }

    @Override
    public void turnRight() {
        int tmp = this.currentDirection.x;
        this.currentDirection.x = this.currentDirection.y;
        this.currentDirection.y = - tmp;
    }
}

