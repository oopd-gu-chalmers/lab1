import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    Scania scania;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getFlatbedAngle() {
        assertEquals(0, scania.getFlatbedAngle());
    }

    @org.junit.jupiter.api.Test
    void raisePlatform() {
        scania.raisePlatform();
        assertEquals(10, scania.getFlatbedAngle());
    }

    @org.junit.jupiter.api.Test
    void lowerPlatform() {
        scania.lowerPlatform();
        assertEquals(0, scania.getFlatbedAngle());
    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        scania.startEngine();
        assertEquals(0.1, scania.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void speedFactor() {
        assertEquals(0.1, scania.speedFactor());
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
        scania.incrementSpeed(1);
        assertEquals(0.1, scania.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void incrementSpeedWithFlatbed() {
        scania.raisePlatform();
        assertThrows(IllegalStateException.class, () -> scania.incrementSpeed(1));
    }
    @org.junit.jupiter.api.Test
    void lowerPlatformWithSpeed() {
        scania.startEngine();
        assertThrows(IllegalStateException.class, () -> scania.lowerPlatform());
    }
}