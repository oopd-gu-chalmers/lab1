import java.awt.*;

abstract class Truck extends Vehicle implements BedInterface{ // A truck is a Vehicle with a bed and a bedAngle

    private BedWithAngleComponent bed; // ta bort

    public Truck(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        this.bed = new BedWithAngleComponent();
    }

    protected double getBedAngle(){ return this.bed.getBedAngle();} //TODO TO SCANIA

    protected void setBedAngle(double newBedAngle){
        this.bed.setBedAngle(newBedAngle, getCurrentSpeed());
    } //TODO TO SCANIA

    @Override
    public void move() {
        if (isBedUp()) {
            super.move(); //If we are overriding the move method from a parent, then we need to use super.move() in our new method instead of this.move() to refer to the old move inherited from parent.
        }
        else {
            throw new IllegalArgumentException("Truck cannot move if Bed angle is not 0.");
        }
    }

    //TODO Override gas and check if bed is up - has to do this on carTransporter as well -> Might want to restructure our code because of this, schematicall

}
