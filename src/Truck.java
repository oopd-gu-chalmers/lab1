import java.awt.*;

public abstract class Truck {
    private final Car car = new Car() {
        @Override
        public double speedFactor() {
            return 1;
        }
    };
    protected boolean backIsClosed = true;
    protected double[] position = car.position;
    protected double[] direction = car.direction;
    protected double enginePower; // Engine power of the car
    protected double currentSpeed = 0; // The current speed of the car
    protected String modelName; // The car model name
    protected int nrDoors;
    protected Color color;

    public Truck(int nrDoors, String modelName, double enginePower) {
        this.nrDoors = nrDoors;
        this.modelName = modelName;
        this.enginePower = enginePower;
    }
    public double[] getPosition() {
        return position;
    }
    public void setPosition(double[] position) {
        car.setPosition(position);
    }
    public double[] getDirection() {
        return direction;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public int getNrDoors() {
        return nrDoors;
    }
    public Color getColor() {
        return color;
    }
    public void startEngine(){
        car.startEngine();
    }

    public void stopEngine(){
        car.stopEngine();
    }

    protected void incrementSpeed(double amount) {
        car.incrementSpeed(amount);
    }

    protected void decrementSpeed(double amount) {
        car.decrementSpeed(amount);
    }

    public void move() {
        car.move();
    }
    public void turnLeft() {
        car.turnLeft();
    }
    public void turnRight() {
        car.turnRight();
    }

    public abstract void raiseBack();

    public abstract void lowerBack();

    public void gas() {
        if (!backIsClosed) car.gas();
    }
    public void brake(double amount) {
        car.brake(amount);
    }
}