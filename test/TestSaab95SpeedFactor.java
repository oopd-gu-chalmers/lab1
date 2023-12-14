import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TestSaab95SpeedFactor {
    private Saab95 saab;
    @Before
    public void init() {
        saab = new Saab95();
    }

    @Test
    public void testInitialSpeedFactor() { //Kanske bara för när turbo off???
        assertEquals(saab.getEnginePower() * 0.01 * 1, saab.speedFactor(), 0.01);
    }

    @Test
    public void testSpeedFactorWhenTurboOn() {
        saab.setTurboOn();
        assertEquals(saab.getEnginePower() * 0.01 * 1.3, saab.speedFactor(), 0.01);
    }
}
