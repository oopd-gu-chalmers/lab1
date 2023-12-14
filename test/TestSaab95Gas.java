import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSaab95Gas {
    private Saab95 saab;
    private double oldSpeed;

    @Before
    public void init() {
        saab = new Saab95();
        oldSpeed = saab.getCurrentSpeed();
    }

    @Test
    public void testIfGasWhenAmountBelowZero() {
        saab.gas(-1);
        assertEquals(oldSpeed, saab.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testIfGasWhenAmountAboveOne() {
        saab.gas(1.1);
        assertEquals(oldSpeed, saab.getCurrentSpeed(), 0.01);
    }


    @Test
    public void testIfGasWhenBetweenZeroAndOne() {
        for (double i = 1; i < 10; i++) {
            oldSpeed = saab.getCurrentSpeed();
            saab.gas(i / 10);
            assertTrue(oldSpeed < saab.getCurrentSpeed());
        }
    }
}