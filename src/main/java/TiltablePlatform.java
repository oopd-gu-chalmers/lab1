public interface TiltablePlatform extends Platform {

    double getPlatformAngle();
    double getMaximumAngle();
    double getMinimumAngle();
    void closePlatform(double angle);
    void openPlatform(double angle);
}