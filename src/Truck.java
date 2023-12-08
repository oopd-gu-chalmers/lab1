import java.awt.*;

public class Truck implements Engine{
    private final Movement movement = new Movement();

    protected  int nrDoors;
    protected Color color;
    protected String modelName;

    public int getNrDoors() {return nrDoors;}
    public void setNrDoors(int nrDoors) {this.nrDoors = nrDoors;}
    public Color getColor() {return color;}
    public void setColor(Color color) {this.color = color;}
    public String getModelName() {return modelName;}
    public void setModelName(String modelName) {this.modelName = modelName;}



    private final double enginePower = 100;

    public double getEnginePower() {return enginePower;}

    private boolean backIsOpen = false;

    public boolean getBackIsOpen(){return backIsOpen;}

    public void setBackIsOpen(boolean backIsOpen){this.backIsOpen = backIsOpen;}

    public double[] getPosition() {return movement.getPosition();}

    public double[] getDirection() {
        return movement.getDirection();
    }

    public double getCurrentSpeed() {
        return movement.getCurrentSpeed();
    }

    public void setPosition(double[] position) {
        movement.setPosition(position);
    }

    public void setDirection(double[] direction) {
        movement.setDirection(direction);
    }

    public void setCurrentSpeed(double currentSpeed) {
        movement.setCurrentSpeed(currentSpeed);
    }

    public double speedFactor() {
        return 1;
    }

    public void move(){movement.move();}

    public void turnLeft(){movement.turnLeft();}

    public void turnRight(){movement.turnRight();}

    public void gas(double amount) {
        if (!backIsOpen) {
            if ((amount >= 0) && (amount <= 1)) {
                this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + this.speedFactor() * amount, enginePower));
            }
        }
    }

    public void brake(double amount) {
        if ((amount >= 0) && (amount <= 1)) {
            this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - speedFactor() * amount, 0));
        }
    }

    public void startEngine(){
        if (!backIsOpen) {
            this.setCurrentSpeed(0.1);
        }
    }

    public void stopEngine(){
        this.setCurrentSpeed(0);
    }
}