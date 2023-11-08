package test;
import org.junit.*;


public class TestSaab95StopEngine {
    @Test
    public void StopEngineSaab95(){
        Saab95 saab = new Saab95();
        saab.stopEngine();
        Assert.assertEquals(0, (int)saab.getCurrentSpeed());
    }
}
