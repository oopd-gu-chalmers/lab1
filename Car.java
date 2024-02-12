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
    protected Point2D.Double cordination = new Point2D.Double(xPos, yPos);

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = 1;
        this.yPos = 0.0;
        this.xPos = 0.0;
    }

    // Getters och setters
    public double getxPos() {
        return xPos;
    }
    public double getyPos() {
        return yPos;
    }
    public String getModelname(){return modelName;}
    public void setxPos(double value){xPos = value;}
    public void setyPos(double value){yPos = value;}
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
    public void setDirection(int i) {direction = i; }
    public int getDirection() { return direction; }

    // Start- och stop -engine.
    public void startEngine() { currentSpeed = 0.1; }
    public void stopEngine() { currentSpeed = 0; }


    // Generell move function för ALLA typer av fordon.
    public void move() {
        direction = this.getDirection();
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

    }

    // Sväng vänster resp. höger.
    public void turnleft() {
        direction++;
        if(direction > 4) {
            direction = 0;
        }
    }
    public void turnright() {
        direction --;
        if(direction < 0) {
            direction = 4;
        }
    }

    // Gasa / Öka farten
    public void gas(double amount) {
        if ((currentSpeed >= 0 && currentSpeed <= getEnginePower()) && (amount >= 0 && amount <= 1)) {
            incrementSpeed(amount);
            currentSpeed = Math.min(currentSpeed,getEnginePower());
        }
        else
            System.out.println("amount is not ok");
        this.move();
    }

    // Bromsa / Minska farten.
    public void brake(double amount) {
        if ((currentSpeed >= 0 && currentSpeed <= getEnginePower()) && (amount >= 0 && amount <= 1)) {
            decrementSpeed(amount);
            currentSpeed = Math.max(currentSpeed, 0);
        }
        else
            throw new IllegalArgumentException("amount to high");
        this.move();
    }

    // Abstrakta metoder som måste finnas i subklasserna. De skiljer från varandra. Här säger vi bara
    // att de måste finnas.
    protected void decrementSpeed(double amount) {};
    protected void incrementSpeed(double amount) {};
}
