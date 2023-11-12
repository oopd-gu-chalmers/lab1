package elements.vehicles;
import java.awt.*;

/**
 * A Truck is a Car extended with a tray, the tray can retract and extend
 */
public abstract class Truck extends Car {

    private boolean trayRetracted; // true if tray is in its retracted position

    public Truck(int nrDoors, double enginePower, String modelName, Color color){
        super(nrDoors, enginePower, modelName, color);
    }

    public void setTrayRetracted(boolean bool){
        trayRetracted = bool;
    }

    public boolean isTrayRetracted(){
        return trayRetracted;
    }

    @Override
    public void startEngine(){
        if (isTrayRetracted()) {
            super.startEngine();
        }
    }
}
