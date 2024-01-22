import java.awt.*;


abstract class Car implements Movable{
    private final int nrDoors;
    private final double enginePower;
    public double currentSpeed; // Lägga till set current speed till exempel?
    private Color color;
    private final String modelName;
    private Position position;
    private double direction;


    public Car(int nrDoors, Color color, int enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.position = new Position(0, 0);
        this.direction = 0;
        stopEngine();
    }
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

    abstract double speedFactor();

    abstract void incrementSpeed(double amount);

    abstract void decrementSpeed(double amount);

    public void gas(double amount){
        incrementSpeed(amount);
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void move(){
        position.set_position(position.get_x() + currentSpeed * Math.cos(Math.toRadians(direction)),
                              position.get_y() + currentSpeed * Math.sin(Math.toRadians(direction)));
    }

    public void turnLeft(double degrees){
        direction = (direction + degrees) % 360;
    }
    // Turn radius/angle begränsning
    public void turnRight(double degrees){
        direction = (direction - degrees) % 360;
    }

    public Position getPosition(){
        return position;
    }

}
