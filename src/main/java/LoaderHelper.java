import java.awt.geom.Point2D;
import java.util.ArrayList;

public class LoaderHelper<T extends Loadable> implements CanLoad<T> {
    private final int maxNrOfItems;
    private final int maximumUnitSize;
    private final int maximumLoadingDistance;
    private Point2D.Double unloadingPosition;
    private ArrayList<T> loadedItems;

    public LoaderHelper(int maxNrOfItems, int maximumUnitSize, int maximumLoadingDistance, Point2D.Double unloadingPosition) {
        this.maxNrOfItems = maxNrOfItems;
        this.maximumUnitSize = maximumUnitSize;
        this.maximumLoadingDistance = maximumLoadingDistance;
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
    public int getMaximumUnitSize() {
        return maximumUnitSize;
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

    public int getMaximumLoadingDistance() {
        return maximumLoadingDistance;
    }
}
