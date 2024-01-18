import java.awt.*;

public class car {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private final double currentSpeed; // The current speed of the car
    private final Color color; // Color of the car
    private final String modelName; // The car model name

    public car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
       this.nrDoors = nrDoors;
       this.enginePower = enginePower;
       this.currentSpeed = currentSpeed;
       this.color = color;
       this.modelName = modelName;
    }
    public car() {}


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
}
