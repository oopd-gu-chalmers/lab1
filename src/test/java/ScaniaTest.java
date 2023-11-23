import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    private final Scania scania = new Scania();

    @Test
    void currentSpeedMustStayZeroWhilePlatformIsOpened() {
        do {
            scania.brake(1);
        } while (scania.getCurrentSpeed() != 0);
        scania.openPlatform();
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());
    }

    @Test
    void platformShouldNotBeAbleToBeOpenedWhenCurrentSpeedIsNotZero() {
        do {
            scania.gas(1);
        } while (scania.getCurrentSpeed() == 0);
        scania.openPlatform();
        assertEquals(scania.getMinAngle(), scania.getPlatformAngle());
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

    @Test
    void platformAngleShouldNeverBeSetAboveMaxAngle() {
        scania.openPlatform();
        scania.openPlatform(20);
        assertEquals(scania.getMaxAngle(), scania.getPlatformAngle());
    }

    @Test
    void platformAngleShouldNeverBeSetBelowMinAngle() {
        scania.closePlatform();
        scania.closePlatform(20);
        assertEquals(scania.getMinAngle(), scania.getPlatformAngle());
    }
}