import java.awt.geom.Point2D;

public interface Movable {
    void move();
    void turnRight();
    void turnLeft();
    Point2D.Double getPosition();
}
