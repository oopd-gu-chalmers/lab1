package assets.elements.vehicles.cars;
import assets.elements.vehicles.Car;
import assets.elements.vehicles.engines.Engine;

import java.awt.*;

/**
 * A Truck is a Car extended with a tray, the tray can retract and extend.
 */
public abstract class Truck extends Car {

    private boolean trayRetracted; // true if tray is in its retracted position

    public Truck(int nrDoors, Engine engine, String modelName, Color color, double height, double weight){
        super(nrDoors, engine, modelName, color, height, weight);
        setTrayRetracted(true);
    }

    protected void setTrayRetracted(boolean bool){
        trayRetracted = bool;
    }

    public boolean isTrayRetracted(){
        return trayRetracted;
    }

}
