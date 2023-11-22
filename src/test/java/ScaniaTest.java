import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    private final Scania scania = new Scania();

    @Test
    void gasShouldNotAffectSpeedWhenPlatformIsOpen() {
        scania.openPlatform();
        double initialSpeed = scania.getCurrentSpeed();
        scania.gas(1);
        assertEquals(initialSpeed, scania.getCurrentSpeed());
    }

    @Test
    void closePlatformShouldSetAngleToMinAngle() {
        scania.openPlatform(20);
        scania.closePlatform();
        assertEquals(scania.getMinAngle(), scania.getPlatformAngle());
    }

    @Test
    void closingPlatformWithAngleShouldDecreaseCurrentAngleByGivenAngle() {
        scania.openPlatform();
        double angle = 20;
        scania.closePlatform(angle);
        assertEquals(scania.getMaxAngle() - angle, scania.getPlatformAngle());
    }

    @Test
    void openPlatformShouldSetAngleToMaxAngle() {
        scania.openPlatform(20);
        scania.openPlatform();
        assertEquals(scania.getMaxAngle(), scania.getPlatformAngle());
    }

    @Test
    void openPlatformWithAngleShouldIncreaseCurrentAngleByGivenAngle() {
        scania.closePlatform();
        double angle = 20;
        scania.openPlatform(angle);
        assertEquals(scania.getMinAngle() + angle, scania.getPlatformAngle());
    }
}