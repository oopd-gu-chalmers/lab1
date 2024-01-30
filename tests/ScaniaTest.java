import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    Scania carA;

    @BeforeEach
    void setUp() {
        carA = new Scania(3, Color.blue, 190, "9000");
    }

    @Test
    void pivotUp() {
        carA.set_platformAngle(0);
        assertEquals(0, carA.get_platformAngle());
        carA.pivotUp();
        assertTrue(carA.get_platformAngle() > 0);
    }

    @Test
    void pivotDown() {
        carA.set_platformAngle(50);
        assertEquals(50, carA.get_platformAngle());
        carA.pivotDown();
        assertTrue(carA.get_platformAngle() < 50);
    }
}