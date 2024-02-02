import java.awt.*;

public abstract class Truck extends Car {
    protected boolean rampState;
    private double angle;
    public Truck() {
        super(2, 90, Color.red, "Lastbil");
        this.rampState = false;
    }

    @Override
    public void gas(double amount) {
        if (bool(amount) && angle == 0 ) {
            incrementSpeed(amount);
            this.setCurrentSpeed(Math.min(this.getCurrentSpeed(), getEnginePower()));
        }
        this.move();
    }

    private boolean bool (double amount) { return this.getCurrentSpeed() >= 0 && this.getCurrentSpeed() <=
            getEnginePower() && (amount >= 0 && amount <= 1);
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

    @Override
    public void move() {
        if (angle != 0) {
            System.out.println("Position: (" + getxPos() + ", " + getyPos() + ')' );
        }

        switch (this.getDirection()) {
            case 0: // north
                setYPos(getyPos() + getCurrentSpeed());
                break;
            case 1: // east
                setXPos(getxPos() + getCurrentSpeed());
                break;
            case 2: // south
                setYPos(getyPos() - getCurrentSpeed());
                break;
            case 3: // west
                setXPos(getxPos() - getCurrentSpeed());
                break;
            default:
                System.out.println("unknown direction");
                break;
        }
        System.out.println("Current Position: (" + this.getxPos() + ", " + this.getyPos() + ")");
        System.out.println("Current direction: " + this.getDirection());
    }

    public abstract void raiseRamp();

    public abstract void lowerRamp();
}
