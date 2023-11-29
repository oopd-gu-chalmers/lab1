import java.awt.*;

public abstract class Truck extends Vehicle{
    protected boolean backIsOpen = false;

    public double speedFactor() {
        return 1;
    }
    public abstract void raiseBack();

    public abstract void lowerBack();

    @Override
    public void gas(double amount) {
        if (!backIsOpen) {
            if ((amount >= 0) && (amount <= 1)) {
                incrementSpeed(amount);
            }
        }
    }
    /*public void gas() {
        if (!backIsOpen) super.gas();
    }*/
}