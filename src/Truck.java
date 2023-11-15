import java.awt.*;

public abstract class Truck extends Car {
    protected boolean backIsClosed = true;



    public double speedFactor() {
        return 1; //TODO: Fixa värden
    }

    public abstract void raiseBack();

    public abstract void lowerBack();

    @Override
    public void gas() {
        if (!backIsClosed) super.gas();
    }
}