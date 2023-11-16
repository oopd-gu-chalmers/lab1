package assets.elements.vehicles.boats;

import assets.elements.Vehicle;

import java.awt.*;

/**
 * A Boat is a Vehicle which moves on water
 * It has a maximum swing which defines the angle the boat can have before it sinks
 */
public abstract class Boat extends Vehicle {
    double maximumSwing; // Maximum rotation of the boat before it sinks
    public Boat(String modelName, Color color, double height, double weight, double maximumSwing) {
        super(modelName, color, height, weight);
        this.maximumSwing = maximumSwing;
    }
}
