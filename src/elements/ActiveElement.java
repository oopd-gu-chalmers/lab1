package elements;

import storages.Storage;

/**
 * An ActiveElement has a position and a rotation, and it can move.
 * An ActiveElement can be mounted onto a storage, and if so it will turn inactive follow the transform of the storage
 */
public abstract class ActiveElement extends Element implements Movable{
    private double speed = 0;
    private Element storageHolder;
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

    public double getSpeed(){
        return speed;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void moveTick(){
        if (storageHolder != null){
            setPosition(storageHolder.getPosition());
            return;
        }
        if (!active) return;

        double[] pos = getPosition();
        pos[0] += getSpeed() * Math.sin(Math.toRadians(getRotation()));
        pos[1] += getSpeed() * Math.cos(Math.toRadians(getRotation()));
        setPosition(pos[0], pos[1]);
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
