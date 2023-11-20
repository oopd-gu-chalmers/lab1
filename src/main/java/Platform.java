public interface Platform {
    boolean platformIsFullyClosed();

    boolean platformIsFullyOpened();

    double getPlatformAngle();

    double getMaximumAngle();

    double getMinimumAngle();

    void closePlatform();

    void openPlatform();
}