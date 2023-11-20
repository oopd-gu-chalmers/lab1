import java.awt.geom.Point2D;

public interface Loadable {
    int getUnitSize();
    boolean isLoaded();
    void load(CanLoad loader);
    void unload(Point2D.Double unloadingPosition);
    CanLoad getLoader();
    Point2D.Double getPosition();
    void updatePosition(Point2D.Double loaderPosition);
}