import java.awt.geom.Point2D;
import java.util.ArrayList;

public class WorkshopImpl<T extends ICar> implements Workshop<T> {
    private final WorkshopHelper<T> workshopHelper;

    public WorkshopImpl(int maxNrOfItems, int maxUnitSize, int maxLoadingDistance, Point2D.Double unloadingPosition) {
        workshopHelper = new WorkshopHelper<>(maxNrOfItems, maxUnitSize, maxLoadingDistance, unloadingPosition);
    }

    @Override
    public int getMaxNrOfItems() {
        return workshopHelper.getMaxNrOfItems();
    }

    @Override
    public int getNrOfAvailableSlots() {
        return workshopHelper.getNrOfAvailableSlots();
    }

    @Override
    public int getMaxUnitSize() {
        return workshopHelper.getMaxUnitSize();
    }

    @Override
    public ArrayList<T> getLoadedItems() {
        return workshopHelper.getLoadedItems();
    }

    @Override
    public boolean load(T item) {
        return workshopHelper.load(item);
    }

    @Override
    public T unload() {
        return workshopHelper.unload();
    }

    @Override
    public Point2D.Double getUnloadingPosition() {
        return workshopHelper.getUnloadingPosition();
    }
}
