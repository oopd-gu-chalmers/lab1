import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class VolvoVAH300 implements ITruck, Platform, CanLoad<ICar> {
    private final Truck truck;
    private final PlatformHelper platformHelper;
    private final LoaderHelper<ICar> loaderHelper;

    public VolvoVAH300() {
        this.truck = new Truck(Color.WHITE, 70, "VolvoVAH300", 2);
        this.platformHelper = new PlatformHelper();
        this.loaderHelper = new LoaderHelper<>(12, 13, 10, null);
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
    public ArrayList<ICar> getLoadedItems() {
        return loaderHelper.getLoadedItems();
    }

    @Override
    public int getMaxUnitSize() {
        return loaderHelper.getMaxUnitSize();
    }

    private double getMaxLoadingDistance() {
        return loaderHelper.getMaxLoadingDistance();
    }

    @Override
    public boolean load(ICar item) {
        if (!canLoadItem(item)) return false;
        return getLoadedItems().add(item);
    }

    private boolean canLoadItem(ICar item) {
    // TODO:
    //  Only load if platform is down
        if (truck.getPosition().distance(item.getPosition()) > getMaxLoadingDistance()) return false;
        if (item.getUnitSize() > getMaxUnitSize()) return false;
        return true;
    }

    @Override
    public ICar unload() {
        if (!platformIsFullyOpened()) return null;
        setUnloadingPosition();
        return getLoadedItems().removeLast();
    }

    @Override
    public Point2D.Double getUnloadingPosition() {
        return loaderHelper.getUnloadingPosition();
    }

    private void setUnloadingPosition() {
        Point2D.Double unitDirectionPoint = truck.getDirection().getUnitDirectionPoint();
        double deltaX = unitDirectionPoint.getX() * loaderHelper.getMaxLoadingDistance();
        double deltaY = unitDirectionPoint.getY() * loaderHelper.getMaxLoadingDistance();
        loaderHelper.setUnloadingPosition(new Point2D.Double(truck.getPosition().getX() - deltaX, truck.getPosition().getY() - deltaY));
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

    // TODO:
    //  Only open platform if standing still
    @Override
    public void openPlatform() {
        platformHelper.openPlatform();
    }

    // TODO:
    //  Only move if platform is closed
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
}