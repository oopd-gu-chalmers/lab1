import org.junit.*;

public class TestSaab95StopEngine {
    @Test
    public void StopEngineSaab95(){
        Saab95 Saab = new Saab95();
        Saab.stopEngine();
        Assert.assertEquals(0, (int)Saab.getCurrentSpeed());
    }
}
