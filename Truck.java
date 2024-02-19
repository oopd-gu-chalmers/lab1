import java.awt.*;

abstract class Truck extends Vehicle{ // A truck is a Vehicle with a bed and a bedAngle

    public BedInterface bed;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int regNum, BedInterface bed){
        super(nrDoors, enginePower, color, modelName, regNum);
    }

    protected double speedFactor(){
        return 8;
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
