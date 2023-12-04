public class Truck implements Engine{
    private final Movement movement = new Movement();

    protected double enginePower;

    protected boolean backIsOpen = false;

    public double speedFactor() {
        return 1;
    }

    public void gas(double amount) {
        if (!backIsOpen) {
            if ((amount >= 0) && (amount <= 1)) {
                movement.setCurrentSpeed(Math.min(movement.getCurrentSpeed() + speedFactor() * amount, enginePower));
            }
        }
    }
}