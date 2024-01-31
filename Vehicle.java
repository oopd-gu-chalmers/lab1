import java.awt.*;
abstract class Vehicle implements Movable{

    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;

    private double currentSpeed;
    private Point pt;
    private double direction;

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName){ //Konstruktor
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

    protected String getModelName(){return modelName;}

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

    public void gas(double amount){
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Gas amount not in correct interval");
        }
    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Break amount not in correct interval");
        }

    }


    @Override
    public void move() {
        double deltaX = getCurrentSpeed() * Math.cos(Math.toRadians(getDirection()));
        double deltaY = getCurrentSpeed() * Math.sin(Math.toRadians(getDirection()));

        Point newPosition = new Point(
                (int) (getPosition().getX() + deltaX),
                (int) (getPosition().getY() + deltaY)
        );

        setPosition(newPosition);
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
    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        if (speedFactor() * amount >= 0){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        }
        else {
            throw new IllegalArgumentException("Increment speed not positive");
        }

    }
    protected void decrementSpeed(double amount){
        if (speedFactor() * amount >= 0){
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        }
        else {
            throw new IllegalArgumentException("Decrement speed not negative");
        }

    }

}
