import java.awt.*;

public abstract class Truck extends Vehicle{
    protected boolean backIsClosed = true;

    public double speedFactor() {
        return 1;
    }
    public abstract void raiseBack();

    public abstract void lowerBack();

    public void gas() {
        if (!backIsClosed) super.gas();
    }
}