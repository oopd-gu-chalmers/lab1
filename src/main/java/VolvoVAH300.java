import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class VolvoVAH300 implements ITruck, Platform, Movable, CanLoad {
    private final Truck truck;
    private final PlatformHelper platformHelper;
    private final ArrayList<Loadable> loadedItems;
    private final int totalCapacity;
    private final int maximumUnitSize;
    private final double maximumLoadingDistance;

    public VolvoVAH300() {
        this.truck = new Truck(Color.WHITE, 70, "VolvoVAH300", 2);
        this.platformHelper = new PlatformHelper();
        this.loadedItems = new ArrayList<>();
        this.totalCapacity = 120;
        this.maximumUnitSize = 13;
        this.maximumLoadingDistance = 10;
    }

    @Override
    public int getTotalCapacity() {
        return totalCapacity;
    }

    @Override
    public int getAvailableCapacity() {
        int usedCapacity = 0;
        for (Loadable loadedItem : loadedItems) {
            usedCapacity += loadedItem.getUnitSize();
        }
        return getTotalCapacity() - usedCapacity;
    }

    @Override
    public ArrayList<Loadable> getLoadedItems() {
        return loadedItems;
    }

    @Override
    public int getMaximumUnitSize() {
        return maximumUnitSize;
    }

    private double getMaximumLoadingDistance() {
        return maximumLoadingDistance;
    }

    @Override
    public boolean load(Loadable item) {
        if (canLoadItem(item)) return false;
        item.load(this);
        return loadedItems.add(item);
    }

    private boolean canLoadItem(Loadable item) {
        if (truck.getPosition().distance(item.getPosition()) > getMaximumLoadingDistance()) return true;
        if (item.getUnitSize() > getMaximumUnitSize()) return true;
        if (!(item instanceof ICar)) return true;
        return false;
    }

    @Override
    public Loadable unloadLast() {
        Loadable item = loadedItems.removeLast();
        item.unload(getUnloadingPosition());
        return item;
    }

    @Override
    public Point2D.Double getUnloadingPosition() {
        Point2D.Double unitDirectionPoint = truck.getDirection().getUnitDirectionPoint();
        double deltaX = unitDirectionPoint.getX() * maximumLoadingDistance;
        double deltaY = unitDirectionPoint.getY() * maximumLoadingDistance;
        return new Point2D.Double(truck.getPosition().getX() - deltaX, truck.getPosition().getY() - deltaY);
    }

    @Override
    public double getEnginePower() {
        return truck.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return truck.getColor();
    }

    @Override
    public void setColor(Color clr) {
        truck.setColor(clr);
    }

    @Override
    public String getModelName() {
        return truck.getModelName();
    }

    @Override
    public void startEngine() {
        truck.startEngine();
    }

    @Override
    public void stopEngine() {
        truck.stopEngine();
    }

    @Override
    public void gas(double amount) {
        truck.gas(amount);
    }

    @Override
    public void brake(double amount) {
        truck.brake(amount);
    }

    @Override
    public boolean engineIsRunning() {
        return truck.engineIsRunning();
    }

    @Override
    public int getNrDoors() {
        return truck.getNrDoors();
    }

    @Override
    public void move() {
        truck.move();
    }

    @Override
    public void turnRight() {
        truck.turnRight();
    }

    @Override
    public void turnLeft() {
        truck.turnLeft();
    }

    @Override
    public Direction getDirection() {
        return truck.getDirection();
    }

    @Override
    public Point2D.Double getPosition() {
        return truck.getPosition();
    }

    @Override
    public boolean platformIsFullyClosed() {
        return platformHelper.platformIsFullyClosed();
    }

    @Override
    public boolean platformIsFullyOpened() {
        return platformHelper.platformIsFullyOpened();
    }

    @Override
    public void closePlatform() {
        platformHelper.closePlatform();
    }

    @Override
    public void openPlatform() {
        platformHelper.openPlatform();
    }
}