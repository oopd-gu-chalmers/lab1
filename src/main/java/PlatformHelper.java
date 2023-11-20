public class PlatformHelper implements Platform {

    private boolean isClosed;

    public PlatformHelper() {
        closePlatform();
    }

    @Override
    public boolean platformIsFullyClosed() {
        return isClosed;
    }

    @Override
    public boolean platformIsFullyOpened() {
        return !isClosed;
    }

    @Override
    public void closePlatform() {
        isClosed = true;
    }

    @Override
    public void openPlatform() {
        isClosed = false;
    }
}