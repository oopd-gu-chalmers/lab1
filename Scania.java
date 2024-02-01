public class Scania extends Truck {
    private final Ramp ramp = new Ramp();
    private int angle;

    public Scania() {
        this.angle = 0;
    }
    public int getAngle() {
        return angle;
    }
    public void setAngle(int amount) {angle = amount;}

    @Override
    public void gas(double amount) {
        if ((this.getCurrentSpeed() >= 0 && this.getCurrentSpeed() <= getEnginePower())
                && (amount >= 0 && amount <= 1) || rampState) {
            incrementSpeed(amount);
            this.setCurrentSpeed(Math.min(this.getCurrentSpeed(), getEnginePower()));
        }
        this.move();
    }
    @Override
    public void raiseRamp() {
        ramp.raiseRamp(this.getCurrentSpeed(), this.angle);
    }
    @Override
    public void lowerRamp() {
        ramp.raiseRamp(this.getCurrentSpeed(), this.angle);
    }
}

