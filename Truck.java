import java.awt.*;

abstract class Truck extends Car { // A truck is a car with a bed and a bedAngle

    private double bedAngle;

    public Truck(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        this.bedAngle = 0;
    }

    protected double getBedAngle(){
        return this.bedAngle;
    }

    protected void setBedAngle(double newBedAngle){
        if (getCurrentSpeed() != 0){
            throw new IllegalArgumentException("Please stop to change the bed angle to 0");
        }
        else if (newBedAngle >= 0 && newBedAngle <= 70){
            this.bedAngle = newBedAngle;
        }
        else {
            throw new IllegalArgumentException("Bed angle not in correct interval");
        }
    }

    @Override
    public void move() {
        // Beräkna nya koordinater baserat på riktningen och hastigheten
        if (getBedAngle() == 0) {
            super.move(); //If we are overriding the move method from a parent, then we need to use super.move() in our new method instead of this.move() to refer to the old move inherited from parent.
        }
        else {
            throw new IllegalArgumentException("Truck cannot move if Bed angle is not 0.");
        }
    }


}
