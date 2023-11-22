import java.awt.geom.Point2D;

public interface Loadable {
    int getUnitSize();
    boolean isLoaded();
    Point2D.Double getPosition();
    void setPositionToLoaderPosition(Point2D.Double loaderPosition);
}