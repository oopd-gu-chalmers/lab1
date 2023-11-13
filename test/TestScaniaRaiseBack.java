import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestScaniaRaiseBack {
    private Scania scania;

    @Before
    public void init() {
        scania = new Scania();
    }

    @Test
    public void testRaiseBackRaises() {
        double oldTilt = scania.getTilt();
        scania.raiseBack(10);
        assertTrue(oldTilt < scania.getTilt());
    }
}