import java.awt.geom.Point2D;
import java.util.ArrayList;

public interface CanLoad {
    int getTotalCapacity();
    int getAvailableCapacity();
    ArrayList<Loadable> getLoadedItems();
    int getMaximumUnitSize();
    boolean load(Loadable item); // Return true if item could be loaded, else false.
    Loadable unloadLast();
    Point2D.Double getUnloadingPosition();
}