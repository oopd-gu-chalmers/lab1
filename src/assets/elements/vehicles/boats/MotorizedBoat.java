package assets.elements.vehicles.boats;

import assets.elements.Vehicle;
import assets.elements.vehicles.Engine;

import java.awt.*;

public class MotorizedBoat extends Boat {
    private Engine engine;
    public MotorizedBoat(Engine engine, String modelName, Color color, double height, double weight, double maximumSwing) {
        super(modelName, color, height, weight, maximumSwing);
        this.engine = engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public double getWeight() {
        return super.getWeight() + engine.getWeight();
    }
}
