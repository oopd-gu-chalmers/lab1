package elements;

import java.awt.*;

public abstract class Vehicle extends ActiveElement implements Drivable, Colorable {
    private final String modelName;
    private Color color;


    public Vehicle(String modelName, Color color) {
        super();
        this.color = color;
        this.modelName = modelName;
    }


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
