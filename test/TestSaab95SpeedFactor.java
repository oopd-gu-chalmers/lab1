import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TestSaab95SpeedFactor {
    @Test
    public void testInitialSpeedFactor() { //Kanske bara för när turbo off???
        Saab95 saab = new Saab95();
        assertEquals(saab.speedFactor(), saab.getEnginePower() * 0.01 * 1, 0.01);
    }

    @Test
    public void testSpeedFactorWhenTurboOn() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        assertEquals(saab.speedFactor(), saab.getEnginePower() * 0.01 * 1.3, 0.01);
    }
}
