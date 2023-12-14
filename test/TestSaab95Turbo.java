import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSaab95Turbo {
    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95();
        saab.setTurboOn();
    }

    @Test
    public void testTurboOn() {
        assertTrue(saab.turboOn);
    }

    @Test
    public void testTurboOff() {
        saab.setTurboOff();
        assertFalse(saab.turboOn);
    }
}
