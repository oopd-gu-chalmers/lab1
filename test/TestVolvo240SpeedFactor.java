import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVolvo240SpeedFactor {
    private Volvo240 volvo;

    @Test
    public void testSpeedFactor() {
        volvo = new Volvo240();
        assertEquals(volvo.enginePower* 0.01 * volvo.trimFactor, volvo.speedFactor(), 0.01);
    }
}
