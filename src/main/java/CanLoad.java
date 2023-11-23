import java.awt.geom.Point2D;
import java.util.ArrayList;

public interface CanLoad<T extends Loadable> {
    ArrayList<T> getLoadedItems();
    int getMaxNrOfItems();
    int getNrOfAvailableSlots();
    int getMaxUnitSize();
    boolean load(T item); // Return true if item could be loaded, else false.
    T unload();
    Point2D.Double getUnloadingPosition();
}