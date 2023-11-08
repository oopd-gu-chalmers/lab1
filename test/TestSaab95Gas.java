import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestSaab95Gas {
    @Test
    public void testIfGasWhenBelowZero() {
        Saab95 saab = new Saab95();
        saab.gas(-1);
        assertFalse(saab.getCurrentSpeed() > 0);
    }

    @Test
    public void testIfGasWhenAboveOne() {
        Saab95 saab = new Saab95();
        saab.gas(1.1);
        assertFalse(saab.getCurrentSpeed() > 0);
    }


    public void testIfGasWhenBetweenZeroAndOne() { //Kanske köra loop genom hela intervallet?
        Saab95 saab = new Saab95();
        saab.gas(0.5);
        assertTrue(saab.getCurrentSpeed() > 0);
    }
}