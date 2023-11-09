import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.*;
public class TestSaab {
    Saab95 saab;
    @Before
    public void before(){
        saab = new Saab95();
    }
    @Test
    public void testSpeedFactorWithTurboOn(){
        saab.setTurboOn();
        assertEquals(saab.speedFactor(), 125 * 0.01 * 1.3, 0);
    }
    @Test
    public void testSpeedFactorWithTurboOff(){
        saab.setTurboOff();
        saab.speedFactor();
        assertEquals(saab.speedFactor(), 125 * 0.01 * 1, 0);
    }
    @Test
    public void testIncrementSpeedBelowEnginePower(){
        saab.incrementSpeed(0.2);
        assertEquals(saab.getCurrentSpeed(), 0 + 100 * 0.01 * 1.25 * 0.2, 0);
    }
    @Test
    public void testIncrementSpeedAboveEnginePower(){
        // Cheat to get speed over 100 but increment speed will never get
        // this high value form porgram
        saab.incrementSpeed(125);
        assertEquals(saab.getCurrentSpeed(), saab.getEnginePower(), 0);
    }

    @Test
    public void testDecrementSpeedBelowZero(){
        saab.decrementSpeed(0.1);
        assertEquals(saab.getCurrentSpeed(), 0, 0);
    }
    @Test
    public void testDecrementSpeedAboveZero(){
        saab.incrementSpeed(0.5);
        saab.decrementSpeed(0.2);
        assertEquals(saab.getCurrentSpeed(), 0.375, 0);
    }
}
