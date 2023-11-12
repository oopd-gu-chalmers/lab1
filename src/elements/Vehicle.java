package elements;

import java.awt.*;

public abstract class Vehicle extends ActiveElement implements Drivable, Colorable, Mountable {
    private final String modelName;
    private Color color;
    private ActiveElement mountedOn;
    private boolean active;


    public Vehicle(String modelName, Color color) {
        super();
        this.color = color;
        this.modelName = modelName;
        this.demount();
        this.setActive(true);
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
        if (!active) return;
        double new_rotation = getRotation();
        new_rotation -= degrees;
        new_rotation = ((360 + new_rotation % 360) % 360); // Limit value to range [0, 360)
        setRotation(new_rotation);

    }

    @Override
    public void turnRight(double degrees){
        if (!active) return;
        double new_rotation = getRotation();
        new_rotation += degrees;
        new_rotation = ((360 + new_rotation % 360) % 360); // Limit value to range [0, 360)
        setRotation(new_rotation);
    }

    public void setActive(boolean bool){
        active = bool;
        if (!bool) {
            setSpeed(0);
        }
    }
    @Override
    public void mount(ActiveElement vehicleToMount){
        mountedOn = vehicleToMount;
        active = false;
    }
    @Override
    public void demount(){
        mountedOn = null;
        active = true;
    }

    @Override
    public boolean isMounted() {
        return mountedOn != null;
    }

    @Override
    public void moveTick(){
        if (mountedOn != null){
            setPosition(mountedOn.getPosition());
            return;
        }
        if (!active) return;
        super.moveTick();
    }

}
