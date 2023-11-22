import java.awt.geom.Point2D;
import java.util.ArrayList;

public class LoaderHelper<T extends Loadable> implements CanLoad<T> {
    private final int maxNrOfItems;
    private final int maxUnitSize;
    private final int maxLoadingDistance;
    private Point2D.Double unloadingPosition;
    private ArrayList<T> loadedItems;

    public LoaderHelper(int maxNrOfItems, int maxUnitSize, int maxLoadingDistance, Point2D.Double unloadingPosition) {
        this.maxNrOfItems = maxNrOfItems;
        this.maxUnitSize = maxUnitSize;
        this.maxLoadingDistance = maxLoadingDistance;
        setUnloadingPosition(unloadingPosition);
    }

    @Override
    public int getMaxNrOfItems() {
        return maxNrOfItems;
    }

    @Override
    public int getNrOfAvailableSlots() {
        int usedCapacity = 0;
        for (T loadedItem : getLoadedItems()) {
            usedCapacity += loadedItem.getUnitSize();
        }
        return getMaxNrOfItems() - usedCapacity;
    }

    @Override
    public ArrayList<T> getLoadedItems() {
        return loadedItems;
    }

    @Override
    public int getMaxUnitSize() {
        return maxUnitSize;
    }
    @Override
    public boolean load(T item) {
        return loadedItems.add(item);
    }

    @Override
    public T unload() {
        return loadedItems.removeLast();
    }

    @Override
    public Point2D.Double getUnloadingPosition() {
        return unloadingPosition;
    }

    public void setUnloadingPosition(Point2D.Double unloadingPosition) {
        this.unloadingPosition = unloadingPosition;
    }

    public int getMaxLoadingDistance() {
        return maxLoadingDistance;
    }
}
