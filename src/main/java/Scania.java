import java.awt.*;

public class Scania implements ITruck, Platform {

    private Truck truck;
    private PlatformHelper platformHelper;

    public Scania() {
        truck = new Truck(Color.LIGHT_GRAY, 90, "Scania", 2);
        platformHelper = new PlatformHelper(0, 70);
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
    public double getPlatformAngle() {
        return platformHelper.getPlatformAngle();
    }

    @Override
    public double getMaximumAngle() {
        return platformHelper.getMaximumAngle();
    }

    @Override
    public double getMinimumAngle() {
        return platformHelper.getMinimumAngle();
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