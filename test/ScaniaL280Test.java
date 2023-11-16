import assets.elements.vehicles.cars.trucks.ScaniaL280;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaniaL280Test {

    ScaniaL280 scania;

    @Before
    public void setUp() {
        scania = new ScaniaL280();
    }

    @Test
    public void trayAngleShouldInitAt0() {
        assertEquals(0, scania.getTrayAngle(), 0.001);
    }

    @Test
    public void trayShouldNotRetractBelow0() {
        scania.retractTray(10);
        assertEquals(0, scania.getTrayAngle(), 0.001);
    }

    @Test
    public void trayShouldExtend() {
        scania.extendTray(45);
        assertEquals(45, scania.getTrayAngle(), 0.001);
    }

    @Test
    public void scaniaShouldNotStartWithExtendedTray() {
        scania.extendTray(10);
        scania.start();
        assertFalse(scania.isStarted());
    }

    @Test
    public void scaniaShouldStartWithRetractedTray() {
        scania.extendTray(10);
        scania.retractTray(15);
        scania.start();
        assertTrue(scania.isStarted());
    }
}