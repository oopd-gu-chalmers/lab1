import java.awt.geom.Point2D;
import java.util.ArrayList;

public class WorkshopHelper<T extends ICar> implements Workshop<T> {
    private final LoaderHelper<T> loaderHelper;

    public WorkshopHelper(int maxNrOfItems, int maxUnitSize, int maxLoadingDistance, Point2D.Double unloadingPosition) {
        loaderHelper = new LoaderHelper<>(maxNrOfItems, maxUnitSize, maxLoadingDistance, unloadingPosition);
    }

    @Override
    public int getMaxNrOfItems() {
        return loaderHelper.getMaxNrOfItems();
    }

    @Override
    public int getNrOfAvailableSlots() {
        return loaderHelper.getNrOfAvailableSlots();
    }

    @Override
    public int getMaxUnitSize() {
        return loaderHelper.getMaxUnitSize();
    }

    @Override
    public ArrayList<T> getLoadedItems() {
        return loaderHelper.getLoadedItems();
    }

    @Override
    public boolean load(T item) {
        return loaderHelper.load(item);
    }

    @Override
    public T unload() {
        return loaderHelper.unload();
    }

    @Override
    public Point2D.Double getUnloadingPosition() {
        return loaderHelper.getUnloadingPosition();
    }
}
