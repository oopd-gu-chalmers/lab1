import java.awt.*;

public class Scania extends Car implements hasRamp {
    private final Ramp ramp;

    public Scania() {
        super(2, 90, Color.cyan, "Scania");
        this.ramp = new Ramp();
        this.ramp.setAngle(0);
    }


    public void raiseRamp() {
        ramp.raiseRamp(this.getCurrentSpeed());
    }

    public void lowerRamp() {
        ramp.lowerRamp(this.getCurrentSpeed());
    }

    public Ramp getRamp() {
        return ramp;
    }

    @Override
    public void gas(double amount) {
        if (this.ramp.getAngle() == 0 && bool(amount)) {
            incrementSpeed(amount);
            this.setCurrentSpeed(Math.min(this.getCurrentSpeed(), getEnginePower()));
        } else  {
            throw new IllegalArgumentException("cant gas");
    }
    }

    private boolean bool(double amount) {
        return this.getCurrentSpeed() >= 0 && this.getCurrentSpeed() <=
                getEnginePower() && (amount >= 0 && amount <= 1);
    }

    private double speedFactor() {
        double trimFactor = 0.8;
        return this.getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    protected void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + speedFactor() * amount, this.getEnginePower()));
    }

    @Override
    protected void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - speedFactor() * amount, 0));
    }

    @Override
    public void move(){
        if(this.ramp.getAngle() == 0) {
            super.move();
        }
    }
    }

