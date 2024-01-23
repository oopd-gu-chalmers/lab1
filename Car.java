import java.awt.*;
abstract class Car implements Movable{

    protected int nrDoors;
    protected double enginePower;
    protected Color color;
    protected String modelName;
    protected double currentSpeed;
    protected Point pt;
    protected double direction;

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

        this.currentSpeed = 0;
        this.pt = new Point(0,0); //start = 0,0
        this.direction = 0; // Riktning i grader (0-360)
    } //Konstruktor

    public int getNrDoors(){return nrDoors;}

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

    public Point getPosition(){
        return pt.getLocation();
    }

    public double getDirection(){
        return direction;
    }

    public void setPosition(Point newPt) {
        this.pt = newPt.getLocation();
    }

    public void setDirection(double newDir) {
        this.direction = newDir;
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
        else {
            System.out.println("Gas amount not in correct interval");
        }
    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
        else {
            System.out.println("Break amount not in correct interval");
        }

    }

    @Override
    public void move() {
        // Beräkna nya koordinater baserat på riktningen och hastigheten
        double deltaX = currentSpeed * Math.cos(Math.toRadians(direction));
        double deltaY = currentSpeed * Math.sin(Math.toRadians(direction));

        // Uppdatera bilens position
        this.pt.x += deltaX;
        this.pt.y += deltaY;
    }

    @Override
    public void turnLeft() {
        // Turn the car left by decreasing its direction angle of deez nuts
        direction -= 90;
        if (direction < 0) {
            direction += 360; // Keep the angle within the range [0, 360]
        }

    }

    @Override
    public void turnRight() {
        // Turn the car right by increasing its direction angle
        direction += 90;
        if (direction >= 360) {
            direction -= 360; // Keep the angle within the range [0, 360]
        }
    }
    public abstract double speedFactor();
    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);

}
