import java.awt.*;

public class Scania extends Truck {

    public Scania(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
    }

    double speedFactor() {
        return this.getEnginePower()*0.005;
    }

    public void pivotUp(){
        try{
        double newAngle = get_platformAngle() + 10;
        if (newAngle > 70){
            throw new Exception("Platform too steep");
        } else if (getCurrentSpeed() > 0) {
            throw new Exception("Can't pivot while moving");
        } else{
            set_platformAngle(newAngle);
        }
    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void pivotDown(){
        try {
        double newAngle = get_platformAngle() - 10;
        if (newAngle < 0){
            throw new Exception("Platform already flat");
        }
        else {
            set_platformAngle(newAngle);
        }
    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
