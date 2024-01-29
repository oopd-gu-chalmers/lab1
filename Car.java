import java.awt.*;

public abstract class Car implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car // behövs pågrund att den behöver uppdateras i volvo, Saab
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private int direction; //
    private double xPos;
    private double yPos;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = 0;
        this.yPos = 0.0;
        this.xPos = 0.0;
    }
    public double getxPos() {
        return xPos;
    }
    public double getyPos() {
        return yPos;
    }
    public void setxPos(double pos) {
        xPos = pos;
    }
    public void setyPos(double pos) {
        yPos = pos;
    }
    public int getNrDoors() {
        return nrDoors;
    }

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
        }
    }

    public void turnleft() {
        direction -= (1 + 4) % 4;
    }

    public void turnright() {
        direction += 1 % 4;
    }

    public void gas(double amount) {
        if ((currentSpeed >= 0 && currentSpeed <= getEnginePower()) && (amount >= 0 && amount <= 1)) {
            incrementSpeed(amount);
            if (currentSpeed > getEnginePower()) {
                currentSpeed = getEnginePower();
                System.out.println("max speed has reached");
            }
        }
        else
            System.out.println("amount is not ok");
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        if ((currentSpeed >= 0 && currentSpeed <= getEnginePower()) && (amount >= 0 && amount <= 1)) {
            decrementSpeed(amount);
            if (currentSpeed < 0) {
                currentSpeed = 0;
                System.out.println("minimum speed has reached");
            }
        }
        else
            throw new IllegalArgumentException("amount to high");
    }

    protected void decrementSpeed(double amount) {};
    protected void incrementSpeed(double amount) {};
}
