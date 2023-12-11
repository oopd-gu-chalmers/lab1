package assets.elements;

import assets.storages.Storage;

/**
 * An Element has an x,y position and a rotation in degrees.
 * It can be mounted to a storage, and if so it will keep the position of the storage.
 */
public abstract class Element {
    private double[] position;
    private double rotation;
    private Storage<? extends Element> storageHolder;

    /**
     * Create an element at 0,0 with rotation 0 degrees
     */
    public Element(){
        resetTransform();
        demount();
    }

    /**
     * Create an element
     * @param position x,y position
     * @param rotation rotation in degrees
     */
    public Element(double[] position, double rotation){
        this.position = position;
        this.rotation = rotation;
        demount();
    }

    /**
     * Sets the position to {@code 0,0} and the rotation to {@code 0} degrees
     */
    public void resetTransform() {
        position = new double[]{0, 0};
        rotation = 0;
    }

    /**
     * Change the position of the element
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void setPosition(double x, double y) {
        position[0] = x;
        position[1] = y;
    }

    /**
     * Change the position of the element
     * @param position x, y coordinate-pair
     */
    public void setPosition(double[] position) {
        this.position = position;
    }

    /**
     * Change the rotation of the element
     *
     * @param rotation rotation in degrees
     */
    public void setRotation(double rotation) {
        this.rotation = ((360 + rotation % 360) % 360); // Limit to [0, 360) degrees
    }

    /**
     * @return rotation in degrees
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * @return x, y coordinate-pair
     */
    public double[] getPosition() {
        return position;
    }

    /**
     * Get the position relative to some rotation and distance of the element
     * @param relativeAngle angle relative to the angle of the element
     * @param relativeDistance relative distance from the element in the direction of the relative angle
     * @return the relative position
     */
    public double[] getRelativePosition(double relativeAngle, double relativeDistance) {
        double[] pos = getPosition();
        pos[0] += relativeDistance * Math.sin(Math.toRadians(getRotation() + relativeAngle));
        pos[1] += relativeDistance * Math.cos(Math.toRadians(getRotation() + relativeAngle));
        return pos;
    }

    /**
     * Get the distance to another element
     * @param other other element
     * @return distance to other
     */
    public double distanceTo(ActiveElement other) {
        double[] pos = getPosition();
        double[] otherPos = other.getPosition();
        return Math.sqrt(Math.pow((pos[0] - otherPos[0]), 2) + Math.pow((pos[1] - otherPos[1]), 2));
    }

    /**
     * Mount the element to a storage
     * @param storageToMount storage to mount
     */
    public void mount(Storage<? extends Element> storageToMount){
        storageHolder = storageToMount;
        setPosition(storageToMount.getOwner().getPosition());
    }

    /**
     * Demount the element, sets storage to {@code null}
     * @param position new position of the demounted element
     */
    public void demount(double[] position){
        storageHolder = null;
        setPosition(position);
    }

    /**
     * Demount the element, sets storage to {@code null}
     */
    public void demount(){
        storageHolder = null;
    }

    /**
     * Get the current storage in which element is mounted
     *
     * @return the current storage holder of the element, null if demounted
     */
    public Storage<? extends Element> getStorageHolder() {
        return storageHolder;
    }
}
