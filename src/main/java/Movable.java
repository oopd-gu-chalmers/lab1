import java.awt.geom.Point2D;

public interface Movable {
    void move();
    void turnRight();
    void turnLeft();
    Direction getDirection();
    Point2D.Double getPosition();
}
