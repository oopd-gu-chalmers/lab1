import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSaab95SpeedFactor {
    @Test
    public void testInitialSpeedFactor(){
        Saab95 saab = new Saab95();
        saab.speedFactor();
        assertEquals(saab.speedFactor(), saab.getEnginePower() * 0.01 * 1);
    }
}



/*public double speedFactor(){ //ser olika ut, turbo istället för trimfactor
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }*/