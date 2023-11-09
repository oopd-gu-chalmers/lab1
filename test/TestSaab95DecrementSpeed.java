import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSaab95DecrementSpeed {
    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95();
        saab.currentSpeed = saab.enginePower;
    }

    @Test
    public void testSpeedDecrements() {
        double oldSpeed;
        oldSpeed = saab.getCurrentSpeed();
        saab.decrementSpeed(1);
        assertTrue(oldSpeed > saab.getCurrentSpeed());
    }

    @Test
    public void testSpeedDecrementAmount() {
        for (int i = 0; i < 10; i++) {
            double oldSpeed;
            oldSpeed = saab.getCurrentSpeed();
            saab.decrementSpeed(i);
            assertEquals(oldSpeed - saab.speedFactor()*i, saab.getCurrentSpeed(), 0.01);
        }
    }
}

