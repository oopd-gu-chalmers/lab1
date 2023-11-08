import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class CarTest {
    @Test 
    public void getNrDoorsTest(){
        
    }

    @RunWith(Suite.class)
    @Suite.SuiteClasses({TestSaab95SpeedFactor.class,TestSaab95StartEngine.class})
    public static class TestSuite {
    }
}
