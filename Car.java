import java.awt.*;
abstract class Car implements Movable{

    protected int nrDoors;
    protected double enginePower;
    protected Color color;
    protected String modelName;
    protected double currentSpeed;
    protected Point pt;
    protected double direction;

    public Car(int nrDoors, double enginePower, Color color, String modelName){ //Konstruktor
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

        this.currentSpeed = 0;
        this.pt = new Point(0,0); //start = 0,0
        this.direction = 90; // Riktning i grader (0-360)
    }

    protected int getNrDoors(){return nrDoors;}

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){return currentSpeed;}

    protected Color getColor(){return color;}

    protected void setColor(Color clr){
	    color = clr;
    }

    protected void startEngine(){
	    currentSpeed = 0.1;
    }

    protected void stopEngine(){
	    currentSpeed = 0;
    }

    protected Point getPosition(){
        return pt.getLocation();
    }

    protected double getDirection(){
        return direction;
    }

    protected void setPosition(Point newPt) {
        this.pt = newPt.getLocation();
    }

    protected void setDirection(double newDir) {
        this.direction = newDir;
    }

    protected void gas(double amount){
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Gas amount not in correct interval");
        }
    }

    protected void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Break amount not in correct interval");
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
        // Turn the car left by decreasing its direction angle
        direction -= 90;
        direction = direction % 360;
    }

    @Override
    public void turnRight() {
        // Turn the car right by increasing its direction angle
        direction += 90;
        direction = direction % 360;
    }
    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        if (speedFactor() * amount >= 0){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        }
        else {
            throw new IllegalArgumentException("Increment speed not positive");
        }

    }
    public void decrementSpeed(double amount){
        if (speedFactor() * amount >= 0){
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        }
        else {
            throw new IllegalArgumentException("Decrement speed not negative");
        }

    }

}
