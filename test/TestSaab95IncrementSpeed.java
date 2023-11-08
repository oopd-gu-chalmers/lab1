import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSaab95IncrementSpeed {
    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95();
    }

    @Test
    public void testSpeedIncrements() {
        double oldSpeed;
        oldSpeed = saab.getCurrentSpeed();
        saab.incrementSpeed(1);
        assertTrue(oldSpeed < saab.getCurrentSpeed());
    }

    @Test
    public void testSpeedIncrementAmount() {
        for (int i = 0; i < 10; i++) {
            double oldSpeed;
            oldSpeed = saab.getCurrentSpeed();
            saab.incrementSpeed(i);
            assertEquals(oldSpeed + saab.speedFactor()*i, saab.getCurrentSpeed(), 0.01);
        }
    }
}