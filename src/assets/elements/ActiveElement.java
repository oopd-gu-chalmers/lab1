package assets.elements;

import assets.Movable;
import assets.storages.Storage;

/**
 * An ActiveElement has a position and a rotation, and it can move.
 * If an ActiveElement is mounted, it will turn inactive and not be controllable.
 */
public abstract class ActiveElement extends Element implements Movable {
    private double speed = 0;
    private boolean active;

    /**
     * An element at {@code 0,0} with rotation {@code 0} degrees
     */
    public ActiveElement(){
        super();
        this.demount();
    }

    public boolean isInactive() {
        return !active;
    }

    public void setActive(boolean bool){
        active = bool;
        if (!bool) {
            setSpeed(0);
        }
    }

    @Override
    public double getSpeed(){
        return speed;
    }

    @Override
    public void setSpeed(double speed){
        this.speed = speed;
    }

    @Override
    public void moveTick(){
        if (getStorageHolder() != null){
            setPosition(getStorageHolder().getOwner().getPosition());
            return;
        }
        if (!active) return;

        setPosition(getRelativePosition(0, getSpeed()));
    }


    @Override
    public void mount(Storage<? extends Element> storageToMount){
        super.mount(storageToMount);
        active = false;
    }

    @Override
    public void demount(double[] position){
        super.demount(position);
        active = true;
    }

    @Override
    public void demount(){
        super.demount();
        active = true;
    }


}
