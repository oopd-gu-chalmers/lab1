import java.awt.*;
abstract class Car implements Movable{

    protected int nrDoors;
    protected double enginePower; 
    protected double currentSpeed;
    protected Color color;
    protected String modelName;
    public double xPos = 0;
    public double yPos = 0;
    public double direction = 0; // Riktning i grader (0-360)

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


    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    //LAB (syntax) QUESTION: do we need @override to override an abstract method?
    @Override
    public void move() {
        // Beräkna nya koordinater baserat på riktningen och hastigheten
        double deltaX = currentSpeed * Math.cos(Math.toRadians(direction));
        double deltaY = currentSpeed * Math.sin(Math.toRadians(direction));

        // Uppdatera bilens position
        xPos += deltaX;
        yPos += deltaY;
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
