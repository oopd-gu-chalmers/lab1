/*import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Truck extends Car {
    protected boolean rampState;
    private double angle;

    public Truck() {
        super(2, 90, Color.red, "Lastbil");
        this.rampState = false;
    }

    @Override
    public void gas(double amount) {
        if (bool(amount) && rampState) {
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
        BilTransport transport = new BilTransport();
        if (angle != 0) {
            System.out.println("Position: (" + getxPos() + ", " + getyPos() + ')' );
        }

        switch (this.getDirection()) {
            case 0: // north
                setyPos(getyPos() + getCurrentSpeed());
                break;
            case 1: // east
                setxPos(getxPos() + getCurrentSpeed());
                break;
            case 2: // south
                setyPos(getyPos() - getCurrentSpeed());
                break;
            case 3: // west
                setxPos(getxPos() - getCurrentSpeed());
                break;
            default:
                System.out.println("unknown direction");
                break;
        }


        System.out.println("Current Position: (" + this.getxPos() + ", " + this.getyPos() + ")");
        System.out.println("Current direction: " + this.getDirection());
    }

    public void updateBilTransport () {
        BilTransport transport = new BilTransport();
        Point2D.Double transportCoordinates = new Point2D.Double(getxPos(), getyPos());
        for (Car c: transport.getFlak()) {
            c.getCordination().setLocation(transportCoordinates);
        }
    }

    public abstract void raiseRamp();

    public abstract void lowerRamp();
}

 */