package WithComposition.Vehicles;

import java.awt.*;

public interface Vehicle extends Movable {

    public String getImage();

    public void setImage(String path);
    public int getNrDoors();

    public String getModelName();

    public double getEnginePower();

    public double getCurrentSpeed();

    public void setCurrentSpeed(double speed);

    public Color getColor();

    public void setColor(Color clr);

    public void startEngine();

    public void stopEngine();

    public void brake(double amount);

    public void gas(double amount);


    public double getDirection();

    public Position getPosition();

    public void setPosition(double x, double y);

}

