public class Truck implements Engine{
    private final Movement movement = new Movement();

    private double enginePower;

    private boolean backIsOpen = false;

    public double speedFactor() {
        return 1;
    }

    public void move(){movement.move();}

    public void turnLeft(){movement.turnLeft();}

    public void turnRight(){movement.turnRight();}

    public void gas(double amount) {
        if (!backIsOpen) {
            if ((amount >= 0) && (amount <= 1)) {
                movement.setCurrentSpeed(Math.min(movement.getCurrentSpeed() + speedFactor() * amount, enginePower));
            }
        }
    }

    public void brake(double amount) {
        if ((amount >= 0) && (amount <= 1)) {
            movement.setCurrentSpeed(Math.max(movement.getCurrentSpeed() - speedFactor() * amount, 0));
        }
    }

    public void startEngine(){
        movement.setCurrentSpeed(0.1);
    }

    public void stopEngine(){
        movement.setCurrentSpeed(0);
    }
}