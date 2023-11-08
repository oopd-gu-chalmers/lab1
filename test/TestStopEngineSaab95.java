package test;
import org.junit.*;

public class TestStopEngineSaab95 {
        Saab95 Saab = new Saab95();
        Saab.stopEngine();
        Assert.assertEquals(0, (int)Saab.getCurrentSpeed());
    }
    
}
