public abstract class Truck extends Car {
    protected boolean backIsClosed = true;

    public Truck() {
        isLoadable = false;
    }

    public double speedFactor() {
        return 1;
    }

    public abstract void raiseBack();

    public abstract void lowerBack();

    @Override
    public void gas() {
        if (!backIsClosed) super.gas();
    }
}