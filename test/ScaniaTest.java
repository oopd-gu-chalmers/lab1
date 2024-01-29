import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    private Scania scania;
    @BeforeEach
    void setUp() {
        scania = new Scania();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void gas() {
    }

    @Test
    void incrementAngle() {
    }

    @Test
    void decrementAngle() {
    }

    @Test
    void raiseRamp() {
        scania.raiseRamp(30);
        assertEquals(30, scania.getRampAngle());

        // Check that ramp can't rise when car is moving
        scania.incrementSpeed(50);
        // We expect that an Exception occurs when we try to rise the ramp while moving
        assertThrows(IllegalArgumentException.class, () -> scania.raiseRamp(1));
    }

    @Test
    void lowerRamp() {
        scania.raiseRamp(50); // Raise ramp at first
        scania.lowerRamp(30);
        assertEquals(20, scania.getRampAngle());

        // Not lower ramp below 0
        assertThrows(IllegalArgumentException.class, () -> scania.lowerRamp(21));
    }

    @Test
    void getRampAngle() {
        assertEquals(0, scania.getRampAngle());
    }

    @Test
    void speedFactor() {
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }
}