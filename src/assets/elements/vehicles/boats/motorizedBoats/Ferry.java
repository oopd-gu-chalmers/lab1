package assets.elements.vehicles.boats.motorizedBoats;

import assets.elements.vehicles.Car;
import assets.elements.vehicles.Engine;
import assets.elements.vehicles.boats.MotorizedBoat;
import assets.storages.StorageStack;

import java.awt.*;

public class Ferry extends MotorizedBoat {
    private final StorageStack<Car> storage;
    private static final int maxStorageSize = 6;
    private static final double reach = 5;
    public Ferry(int lanes, Engine engine) {
        super(engine, modelName, color, height, weight, maximumSwing);

    }
}
