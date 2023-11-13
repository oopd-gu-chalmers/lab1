package assets.elements.vehicles.boats;

import assets.elements.Vehicle;

import java.awt.*;

public class Boat extends Vehicle {
    double maximumSwing; // Maximum rotation of the boat before it sinks
    public Boat(String modelName, Color color, double height, double weight, double maximumSwing) {
        super(modelName, color, height, weight);
        this.maximumSwing = maximumSwing;
    }
}
