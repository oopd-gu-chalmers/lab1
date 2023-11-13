import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestScaniaLowerBack {
    private Scania scania;
    private double oldTilt;

    @Before
    public void init() {
        scania = new Scania();
        scania.raiseBack(70);
        oldTilt = scania.getTilt();
    }

    @Test
    public void testLowerBackLowers() {
        scania.lowerBack(10);
        assertTrue(oldTilt > scania.getTilt());
    }

    @Test
    public void testLowerBackAmount() {
        scania.lowerBack(10);
        assertEquals(60, scania.getTilt(), 0.01);
    }

    @Test
    public void testNegativeLowerAmount() {
        scania.lowerBack(-10);
        assertEquals(oldTilt, scania.getTilt(), 0.01);
    }

    @Test
    public void testExcessiveTilt() {
        scania.lowerBack(80);
        assertEquals(0, scania.getTilt(), 0.01);
    }
}
