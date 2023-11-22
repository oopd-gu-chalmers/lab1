public interface TiltablePlatform extends Platform {

    double getPlatformAngle();
    double getMaxAngle();
    double getMinAngle();
    void closePlatform(double angle);
    void openPlatform(double angle);
}