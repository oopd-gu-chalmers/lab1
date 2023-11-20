public class PlatformHelper implements Platform {

    private double platformAngle;
    private final double maximumAngle; // "Open"
    private final double minimumAngle; // "Closed"

    public PlatformHelper(double minimumAngle, double maximumAngle) {
        this.maximumAngle = maximumAngle;
        this.minimumAngle = minimumAngle;
        closePlatform();
    }

    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = Math.max(Math.min(platformAngle, getMaximumAngle()), getMinimumAngle());
    }

    @Override
    public boolean platformIsFullyClosed() {
        return getPlatformAngle() == getMinimumAngle();
    }

    @Override
    public boolean platformIsFullyOpened() {
        return getPlatformAngle() == getMaximumAngle();
    }

    @Override
    public double getPlatformAngle() {
        return platformAngle;
    }

    @Override
    public double getMaximumAngle() {
        return maximumAngle;
    }

    @Override
    public double getMinimumAngle() {
        return minimumAngle;
    }

    @Override
    public void closePlatform() {
        setPlatformAngle(getMinimumAngle());
    }

    @Override
    public void openPlatform() {
        setPlatformAngle(getMaximumAngle());
    }
}