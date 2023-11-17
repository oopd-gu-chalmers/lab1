public interface TiltablePlatform {
    boolean platformIsFullyClosed();
    boolean platformIsFullyOpened();
    double getPlatformAngle();
    double getMaximumAngle();
    double getMinimumAngle();
    void closePlatform();
    void openPlatform();
    void closePlatform(double angle);
    void openPlatform(double angle);
}
