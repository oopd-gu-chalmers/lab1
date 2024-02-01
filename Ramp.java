import java.lang.annotation.Documented;

public class Ramp implements IRamp{

    public void lowerRamp(double speed, double angle) {
        if (speed == 0) {
            angle -= 10;
            if (angle < 0) {
                angle = 0;
            }
        }
        else throw new IllegalArgumentException("Scania is moving, can't lower the flak!");
    }

    public void raiseRamp(double speed, double angle) {
        if(speed == 0) {
            angle += 10;
            if (angle > 70) {
                angle = 70;
            }
        }
        else throw new IllegalArgumentException("Scania is moving, can't raise the flak!");
    }

    public void raiseRamp(double speed, boolean rampState) {
        if(speed == 0) {
            rampState = true;
        }
        else throw new IllegalArgumentException("cant raise ramp car is moving");
    }
}
