public class TiltablePlatformHelper implements TiltablePlatform {

    private final double minimumAngle;
    private final double maximumAngle;
    private double platformAngle;

    public TiltablePlatformHelper(double minimumAngle, double maximumAngle) {
        this.minimumAngle = minimumAngle;
        this.maximumAngle = maximumAngle;
        this.platformAngle = minimumAngle;
    }

    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = Math.max(getMinimumAngle(), Math.min(getMaximumAngle(), platformAngle));
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
    public double getMinimumAngle() {
        return minimumAngle;
    }

    @Override
    public double getMaximumAngle() {
        return maximumAngle;
    }

    @Override
    public void openPlatform() {
        setPlatformAngle(getMaximumAngle());
    }

    @Override
    public void openPlatform(double angle) {
        setPlatformAngle(getPlatformAngle() + angle);
    }

    @Override
    public void closePlatform() {
        setPlatformAngle(getMinimumAngle());
    }

    @Override
    public void closePlatform(double angle) {
        setPlatformAngle(getPlatformAngle() - angle);
    }
}