public class TiltablePlatformHelper implements TiltablePlatform {

    private final PlatformHelper platformHelper;
    public TiltablePlatformHelper(double minimumAngle, double maximumAngle) {
        this.platformHelper = new PlatformHelper(minimumAngle, maximumAngle);
    }

    public void setPlatformAngle(double platformAngle) {
        platformHelper.setPlatformAngle(platformAngle);
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

    @Override
    public void closePlatform(double angle) {
        setPlatformAngle(getPlatformAngle() - angle);
    }

    @Override
    public void openPlatform(double angle) {
        setPlatformAngle(getPlatformAngle() + angle);
    }
}