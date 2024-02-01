import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    private Scania scania;

    @BeforeEach
    void setUp() {
        this.scania = new Scania();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBedAngle() {
        assertEquals(0, scania.getBedAngle());
    }

    @Test
    void setBedAngle() {
        scania.setBedAngle(30);
        assertEquals(30, scania.getBedAngle());
    }

    @Test
    void move() {
        scania.gas(1);
        Point scaniaStartPosition = scania.getPosition();
        scania.move();
        assertNotEquals(scaniaStartPosition, scania.getPosition());
    }

    @Test
    void move1() {
        assertThrows(IllegalArgumentException.class, () -> {
            scania.setBedAngle(30);
            scania.gas(1);
            scania.move();
        });

    }

}
