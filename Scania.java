import java.awt.*;

public class Scania extends Car{
    private double angleRamp; // The angle of the ramp of the truck
    public Scania() {
        super(2, Color.black, 250, "Scania");
        angleRamp = 0;
    }

    private void setAngleRamp(double angle){
        angleRamp = angle;
    }

    protected double getAngleRamp(){
        return angleRamp;
    }

    public void decreaseAngleRamp(double angle){
        // Decreasing the angle moves the ramp up
        if(currentSpeed == 0 && angle >= 0){
            angleRamp = angleRamp - angle;
            if(angleRamp < 0){
                angleRamp = 0;
            }
        }
    }

    public void increaseAngleRamp(double angle){
        // Increase the angle moves the ramp down
        if(currentSpeed == 0 && angle >= 0){
            angleRamp = angleRamp + angle;
            if(angleRamp > 70){
                angleRamp = 70;
            }
        }

    }
    //    if angle > 0:
    //    prevent call to move

    @Override
    public void move(){
        // Scania can only move when the ramp is up
        if(angleRamp == 0){
            super.move();
        }
    }




}
