import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TiltablePlatformHelperTest {
    TiltablePlatformHelper platformHelper = new TiltablePlatformHelper(0, 70);

    @Test
    void closePlatform() {
        platformHelper.setPlatformAngle(10);
        platformHelper.closePlatform();
        assertTrue(platformHelper.platformIsFullyClosed());
    }

    @Test
    void openPlatform() {
        platformHelper.setPlatformAngle(10);
        platformHelper.openPlatform();
        assertTrue(platformHelper.platformIsFullyOpened());
    }
}