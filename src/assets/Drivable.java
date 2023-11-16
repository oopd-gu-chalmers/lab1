package assets;

/**
 * A Drivable has a speed and can move, it can also be steered
 */
public interface Drivable extends Movable {

    /**
     * Turns to the left
     * @param degrees degrees to turn
     */
    void turnLeft(double degrees);

    /**
     * Turns to the right
     * @param degrees degrees to turn
     */
    void turnRight(double degrees);
}
