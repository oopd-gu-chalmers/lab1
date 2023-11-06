import org.junit.Before;
import org.junit.Test;

public class TestVolvo240 {
    @Before
    public void Setup(){
        Volvo240 newVolvo = new Volvo240();
    }
    @Test
    public void TestSpeedFactor(){

    }
    @Test
    public void TestIncrementSpeed(){

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
    public void TestDecrementSpeed(){

    }
    @Test
    public void TestGas(){

    }
    @Test
    public void TestBreak(){

    }

}
