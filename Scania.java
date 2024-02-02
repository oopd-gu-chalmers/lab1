import java.awt.*;

public class Scania extends Car implements HasRamp {
    private final Ramp ramp = new Ramp();;

    public Scania() {
        super(2, 90, Color.red, "Scania");
    }
    @Override
    public void raiseRamp() {
        ramp.raiseRamp(this.getCurrentSpeed(), ramp.getAngle());
    }
    @Override
    public void lowerRamp() {
        ramp.lowerRamp(this.getCurrentSpeed(), ramp.getAngle());
    }

    public Ramp getRamp () { return ramp; }

    @Override
    public void move() {
        if (ramp.getAngle() != 0) {
            System.out.println("Cannot move");
        } else {
            super.move();
            this.getPosition().setLocation(getPosition());
        }
    }

    private double speedFactor() {
        double trimFactor = 0.8;
        return this.getCurrentSpeed() * 0.01 * trimFactor;
    }
    protected void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + speedFactor() * amount, this.getEnginePower()));
    }
    protected void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - speedFactor() * amount, 0));
    }
}

