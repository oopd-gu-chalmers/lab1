package elements;

/**
 * A Movable has a speed, and can move over time
 */
public interface Movable {
    /**
     * The method to call for every tick the Movable should move
     */
    void moveTick();

    /**
     * @return the current speed of the element
     */
    double getSpeed();

    /**
     * Change the current speed of the element
     * @param speed the new speed
     */
    void setSpeed(double speed);
}
