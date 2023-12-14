import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSaab95StartEngine {
    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95();
    }

    @Test
    public void testInitialSpeed() {
        assertEquals(0, saab.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testStartEngineIncreasesSpeed() {
        double speed = saab.getCurrentSpeed();
        saab.startEngine();
        assertTrue(speed < saab.getCurrentSpeed());
    }

    @Test
    public void testStartEngineSpeedValue() {
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(), 0.01);
    }
}
