import org.junit.Before;
import org.junit.Test;

public class TestVolvo240 {
    private Volvo240 newVolvo;

    @Before
    public void Setup() {
        newVolvo = new Volvo240();

    }
    @Test
    public void TestSpeedFactor() {
        double spf = newVolvo.speedFactor();
        assert spf == 1.25;
    }

    @Test
    public void TestIncrementSpeedLessThanEnginePower() {
        newVolvo.incrementSpeed(10);
        // enginePower = 100
        // currentSpeed = 0 + 1.25*10 (12.5)
        double current = newVolvo.getCurrentSpeed();
        assert current == 12.5;

    }
    @Test
    public void TestIncrementSpeedMoreThanEnginePower() {
        newVolvo.incrementSpeed(100);
        // enginePower = 100
        // currentSpeed = 0 + 1.25*100 = (125)
        double current = newVolvo.getCurrentSpeed();
        assert current == 100;

    }

    @Test
    public void TestDecrementSpeed() {
        newVolvo.incrementSpeed(10);
        // enginePower = 100
        // currentSpeed = 0 + 1.25*10  = 12.5
        double before = newVolvo.getCurrentSpeed();

        newVolvo.decrementSpeed(9);
        // 0
        // currentSpeed = 12.5 - 1.25*9 = 1.25
        double after = newVolvo.getCurrentSpeed();

        assert after == 1.25;
    }
    @Test
    public void TestGas() {

    }
    @Test
    public void TestBreak() {

    }

}
