package elements;

import java.awt.*;

public abstract class Vehicle extends Element implements Drivable, Colorable{
    private final String modelName;
    private Color color;

    public Vehicle(String modelName, Color color) {
        super();
        this.color = color;
        this.modelName = modelName;
    }

    public Vehicle(String modelName, Color color, double[] position, double rotation) {
        super(position, rotation);
        this.color = color;
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }

    public void turnLeft(double degrees){
        double new_rotation = getRotation();
        new_rotation -= degrees;
        new_rotation = ((360 + new_rotation % 360) % 360); // Limit value to range [0, 360)
        setRotation(new_rotation);

    }
    public void turnRight(double degrees){
        double new_rotation = getRotation();
        new_rotation += degrees;
        new_rotation = ((360 + new_rotation % 360) % 360); // Limit value to range [0, 360)
        setRotation(new_rotation);
    }
}
