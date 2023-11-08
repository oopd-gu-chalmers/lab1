import org.junit.*;
import static org.junit.Assert.assertTrue;

public class TestSaab95StartEngine {
    @Test
    public void testStartEngineSetsSpeed(){
        Saab95 saab = new Saab95();
        double speed = saab.getCurrentSpeed();
        saab.startEngine();
        assertTrue(speed < saab.getCurrentSpeed());
    }
}
