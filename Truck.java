import java.awt.*;

abstract class Truck extends Car{

    private double platformAngle;
    public Truck(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);

    }

    public double get_platformAngle(){
        return this.platformAngle;
    }

    public void set_platformAngle(double angle){
        this.platformAngle = angle;
    }

    abstract void pivotUp();

    abstract void pivotDown();


}
