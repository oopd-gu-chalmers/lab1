package assets.elements;

import assets.Colorable;
import assets.Drivable;

import java.awt.*;
import java.util.Arrays;

/**
 * A Vehicle is an ActiveElement which is drivable.
 * A Vehicle is also colorable.
 * A Vehicle also has a model name, a height and a weight.
 */
public abstract class Vehicle extends ActiveElement implements Drivable, Colorable {
    private final String modelName;
    private Color color;
    private final double height;
    private final double weight;

    /**
     *
     * @param modelName the model name of the vehicle
     * @param color the initial color of the vehicle
     * @param height the height of the vehicle
     * @param weight the bare weight of the vehicle
     */
    public Vehicle(String modelName, Color color, double height, double weight) {
        super();
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.modelName = modelName;
    }

    /**
     * @return the height of the vehicle
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the current weight of the vehicle
     */
    public double getWeight(){return weight;}

    /**
     * @return the model name of the vehicle
     */
    public String getModelName() {
        return modelName;
    }

    @Override
    public void setColor(Color color){
        this.color = color;
    }

    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public void turnLeft(double degrees){
        if (isInactive()) return;
        double newRotation = getRotation();
        setRotation(newRotation + degrees);
    }

    @Override
    public void turnRight(double degrees){
        if (isInactive()) return;
        double newRotation = getRotation();
        setRotation(newRotation - degrees);
    }
}
