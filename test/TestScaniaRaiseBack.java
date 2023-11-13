import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestScaniaRaiseBack {
    private Scania scania;
    private double oldTilt;

    @Before
    public void init() {
        scania = new Scania();
        oldTilt = scania.getTilt();
    }

    @Test
    public void testRaiseBackRaises() {
        scania.raiseBack(10);
        assertTrue(oldTilt < scania.getTilt());
    }

    @Test
    public void testRaiseBackAmount() {
        scania.raiseBack(10);
        assertEquals(10, scania.getTilt(), 0.01);
    }

    @Test
    public void testNegativeRaiseAmount() {
        scania.raiseBack(-10);
        assertEquals(oldTilt, scania.getTilt(), 0.01);
    }

    @Test
    public void testExcessiveTilt() {
       scania.raiseBack(80);
       assertEquals(70, scania.getTilt(), 0.01);
    }
}