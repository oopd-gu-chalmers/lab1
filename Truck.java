import java.awt.*;

abstract class Truck extends Vehicle{ // A truck is a Vehicle with a bed and a bedAngle

    private BedWithAngleComponent bed;

    public Truck(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        this.bed = new BedWithAngleComponent();
    }

    protected double getBedAngle(){
        return this.bed.getBedAngle();
    }

    protected void setBedAngle(double newBedAngle){
        this.bed.setBedAngle(newBedAngle, getCurrentSpeed());
    }

    @Override
    public void move() {
        if (getBedAngle() == 0) {
            super.move(); //If we are overriding the move method from a parent, then we need to use super.move() in our new method instead of this.move() to refer to the old move inherited from parent.
        }
        else {
            throw new IllegalArgumentException("Truck cannot move if Bed angle is not 0.");
        }
    }


}
