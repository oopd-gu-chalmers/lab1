import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSaab95Brake {
    private Saab95 saab;
    private double oldSpeed;

    @Before
    public void init() {
        saab = new Saab95();
        saab.currentSpeed = saab.enginePower;
        oldSpeed = saab.getCurrentSpeed();
    }

    @Test
    public void testIfBrakeWhenAmountBelowZero() {
        saab.brake(-1);
        assertEquals(oldSpeed, saab.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testIfBrakeWhenAmountAboveOne() {
        saab.brake(1.1);
        assertEquals(oldSpeed, saab.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testIfBrakeWhenBetweenZeroAndOne() {
        for (double i = 10; i > 1; i--) {
            oldSpeed = saab.getCurrentSpeed();
            saab.brake(i / 10);
            assertTrue(oldSpeed > saab.getCurrentSpeed());
        }
    }
}