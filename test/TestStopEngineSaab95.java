package test;
import org.junit.*;
import src.Saab95;
import src.Car;

public class TestStopEngineSaab95 {
    @Test
    public void StopEngineSaab95(){
        Saab95 Saab = new Saab95();
        Saab.stopEngine();
        Assert.assertEquals(0, Saab.currentSpeed());
    }
    
}
