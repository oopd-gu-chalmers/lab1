import java.awt.*;

abstract class Truck extends Vehicle implements BedInterface{ // A truck is a Vehicle with a bed and a bedAngle

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int regNum){
        super(nrDoors, enginePower, color, modelName, regNum);
    }

    protected double speedFactor(){
        return 8;
    }

    @Override
    public void move() {
        if (isBedUp()) {
            super.move(); //If we are overriding the move method from a parent, then we need to use super.move() in our new method instead of this.move() to refer to the old move inherited from parent.
        }
        else {
            throw new IllegalArgumentException("Truck cannot move if Bed is down.");
        }
    }

    @Override
    public void gas(double amount) {
        if (isBedUp()) {
            super.gas(amount);
        }
        else {
            throw new IllegalArgumentException("Truck cannot move if Bed is down.");
        }
    }


    //TODO Override gas and check if bed is up - has to do this on carTransporter as well -> Might want to restructure our code because of this, schematically

}
