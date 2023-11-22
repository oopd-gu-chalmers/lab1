public class TiltablePlatformHelper implements TiltablePlatform {

    private final double minAngle;
    private final double maxAngle;
    private double platformAngle;

    public TiltablePlatformHelper(double minAngle, double maxAngle) {
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
        this.platformAngle = minAngle;
    }

    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = Math.max(getMinAngle(), Math.min(getMaxAngle(), platformAngle));
    }

    @Override
    public boolean platformIsFullyClosed() {
        return getPlatformAngle() == getMinAngle();
    }

    @Override
    public boolean platformIsFullyOpened() {
        return getPlatformAngle() == getMaxAngle();
    }

    @Override
    public double getPlatformAngle() {
        return platformAngle;
    }

    @Override
    public double getMinAngle() {
        return minAngle;
    }

    @Override
    public double getMaxAngle() {
        return maxAngle;
    }

    @Override
    public void openPlatform() {
        setPlatformAngle(getMaxAngle());
    }

    @Override
    public void openPlatform(double angle) {
        setPlatformAngle(getPlatformAngle() + angle);
    }

    @Override
    public void closePlatform() {
        setPlatformAngle(getMinAngle());
    }

    @Override
    public void closePlatform(double angle) {
        setPlatformAngle(getPlatformAngle() - angle);
    }
}