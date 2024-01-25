import java.awt.*;

abstract class Truck extends Car{ // A truck is a car with a bed and a bedAngle

    protected double bedAngle;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, double bedAngle){
        super(nrDoors, enginePower, color, modelName);
        this.bedAngle = bedAngle;
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
            double deltaX = currentSpeed * Math.cos(Math.toRadians(direction));
            double deltaY = currentSpeed * Math.sin(Math.toRadians(direction));

            // Uppdatera bilens position
            this.pt.x += deltaX;
            this.pt.y += deltaY;
        }
        else {
            throw new IllegalArgumentException("Truck cannot move if Bed angle is not 0.");
        }
    }



}
