import java.lang.annotation.Documented;

public class Ramp implements IRamp{
    private double angle;
    private boolean rampState;

    public void angleSet(double a) { angle = a; }
    public double getAngle() { return angle; }
    public boolean getRampState() { return rampState; }
    public void setRampState(boolean b) { rampState = b;}
    public void lowerRamp(double speed, double a) {
        if (speed == 0) {
            a -= 10;
            if (a < 0) {
                a = 0;
            }
            angle = a;
        }
        else throw new IllegalArgumentException("Scania is moving, can't lower the flak!");
    }

    public void raiseRamp(double speed, double a) {
        angle = a;
        if(speed == 0) {
            angle += 10;
            if (angle >= 70) {
                angle = 70;
            }
        }
        else throw new IllegalArgumentException("Scania is moving, can't raise the flak!");
    }

    public void raiseRamp(double speed, boolean r) {
        rampState = r;
        if(speed == 0) {
            rampState = true;
        }
        else throw new IllegalArgumentException("cant raise ramp car is moving");
    }

    public void lowerRamp(double speed, boolean r) {
        rampState = r;
        if(speed == 0) {
            rampState = false;
        }
        else throw new IllegalArgumentException("cant lower ramp car is moving");
    }
}
