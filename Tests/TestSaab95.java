import org.junit.Before;
import org.junit.Test;

public class TestSaab95 {
    private Saab95 TestSaab;
    @Before
    public void setup() {
        TestSaab = new Saab95();
    }
    @Test
    public void TestSetTurboOn(){
        TestSaab.setTurboOn();

        assert TestSaab.turboOn;

    }
    @Test
    public void TestSetTurboOff(){
        TestSaab.setTurboOff();
        assert !TestSaab.turboOn;
    }


    @Test
    public void TestSpeedFactorTurboOn(){
        TestSaab.setTurboOn();
        assert TestSaab.speedFactor() == 125 * 0.01 * 1.3;


    }
    @Test
    public void TestSpeedFactorTurboOff(){
        TestSaab.setTurboOff();
        assert TestSaab.speedFactor() == 125 * 0.01 * 1.0;

    }
    @Test
    public void TestIncrementSpeedTurboOn(){
        TestSaab.setTurboOn();
        TestSaab.incrementSpeed(10);
        // 0 + 125 * 0.01 * 1.3 * 10
        assert TestSaab.getCurrentSpeed() == 0 + 125 * 0.01 * 1.3 * 10;

    }
    @Test
    public void TestIncrementSpeedTurboOff(){
        TestSaab.setTurboOff();
        TestSaab.incrementSpeed(10);
        // 0 + 125 * 0.01 * 1.0 * 10
        assert TestSaab.getCurrentSpeed() == 0 + 125 * 0.01 * 1.0 * 10;

    }
    @Test
    public void TestdecrementSpeedTurboOn(){
        TestSaab.setTurboOn();
        TestSaab.incrementSpeed(10);
        TestSaab.decrementSpeed(5);
        // (0 + 125 * 0.01 * 1.3 * 10) - (125 * 0.01 * 1.3 * 5)
        assert TestSaab.getCurrentSpeed() == (0 + 125 * 0.01 * 1.3 * 10) - (125 * 0.01 * 1.3 * 5);

    }
    @Test
    public void TestdecrementSpeedTurboOff(){
        TestSaab.incrementSpeed(10);
        TestSaab.decrementSpeed(5);
        // (0 + 125 * 0.01 * 1.3 * 10) - (125 * 0.01 * 1.3 * 5)
        assert TestSaab.getCurrentSpeed() == (0 + 125 * 0.01 * 1.0 * 10) - (125 * 0.01 * 1.0 * 5);

    }
}
