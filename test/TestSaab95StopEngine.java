import org.junit.*;

public class TestSaab95StopEngine {
    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95();
        saab.startEngine();
    }

    @Test
    public void testStopEngineValue(){
        saab.stopEngine();
        Assert.assertEquals(0, saab.getCurrentSpeed(), 0.01);
    }
}
