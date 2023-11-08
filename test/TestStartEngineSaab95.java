import org.junit.*;
import static org.junit.Assert.assertTrue;

public class TestStartEngineSaab95 {
    @Test
    public void testStartEngineSetsSpeed(){
        Saab95 saab = new Saab95();
        saab.startEngine();
        assertTrue(saab.currentSpeed > 0);
    }
}
