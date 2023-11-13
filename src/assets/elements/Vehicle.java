package assets.elements;

import assets.Colorable;
import assets.Drivable;

import java.awt.*;

/**
 *
 */
public abstract class Vehicle extends ActiveElement implements Drivable, Colorable {
    private final String modelName;
    private Color color;
    private final double height;
    private double weight;

    public Vehicle(String modelName, Color color, double height, double weight) {
        super();
        this.height = height;
        this.color = color;
        this.modelName = modelName;
    }

    public double getHeight() {
        return height;
    }
    public double getWeight(){return weight;}

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
        setRotation(newRotation - degrees);
    }

    @Override
    public void turnRight(double degrees){
        if (isInactive()) return;
        double newRotation = getRotation();
        setRotation(newRotation + degrees);
    }
}
