import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car // behövs pågrund att den behöver uppdateras i volvo, Saab
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private int direction; //
    private double xPos;
    private double yPos;
    private Point2D.Double cordination;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.cordination = new Point2D.Double(xPos, yPos);
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = 0;
        this.yPos = 0.0;
        this.xPos = 0.0;
    }

    // Getters och setters
    public double setXPos(double d) { return xPos = d;}
    public double setYPos(double d) { return yPos = d;}
    public double getxPos() {
        return xPos;
    }
    public double getyPos() {
        return yPos;
    }
    public Point2D.Double getCordination(){
        return cordination;
    }
    public int getNrDoors() {return nrDoors;}
    public void setCurrentSpeed(double amount) {currentSpeed = amount;}
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

    public void setDirection(int i) {
        direction = i;
    }

    public int getDirection() {
        return direction;
    }

    public void move() {
        switch (direction) {
            case 0: // north
                yPos += currentSpeed;
                break;
            case 1: // east
                xPos += currentSpeed;
                break;
            case 2: // south
                yPos -= currentSpeed;
                break;
            case 3: // west
                xPos -= currentSpeed;
                break;
            default:
                System.out.println("unknown direction");
                break;
        }
        System.out.println("Current Position: (" + xPos + ", " + yPos + ")");
        System.out.println("Current direction: " + direction);
    }

    public void turnleft() {
        direction ++;
        if (direction > 4) {
            direction = 0;
        }
    }

    public void turnright() {
        direction --;
        if (direction < 0) {
            direction = 4;
        }
    }

    public void gas(double amount) {
        if ((currentSpeed >= 0 && currentSpeed <= getEnginePower()) && (amount >= 0 && amount <= 1)) {
            incrementSpeed(amount);
            currentSpeed = Math.min(currentSpeed, getEnginePower());
        }
        this.move();
    }

    public void brake(double amount) {
        if ((currentSpeed >= 0 && currentSpeed <= getEnginePower()) && (amount >= 0 && amount <= 1)) {
            decrementSpeed(amount);
            currentSpeed = Math.max(currentSpeed, 0);
        }
    }

    protected void decrementSpeed(double amount) {};
    protected void incrementSpeed(double amount) {};
}
