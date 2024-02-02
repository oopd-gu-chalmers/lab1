public class Scania extends Truck {
    private double angle;
    private final Ramp ramp;

    public Scania() {
        this.ramp = new Ramp();
        this.angle = this.ramp.getAngle();
    }

    @Override
    public void gas(double amount) {
        if ((this.getCurrentSpeed() >= 0 && this.getCurrentSpeed() <= getEnginePower())
                && (amount >= 0 && amount <= 1) || ramp.getRampState()) {
            incrementSpeed(amount);
            this.setCurrentSpeed(Math.min(this.getCurrentSpeed(), getEnginePower()));
        }
        this.move();
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
}

