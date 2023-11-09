import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestVolvo {
    Volvo240 volvo;
    @Before
    public void before(){
        volvo = new Volvo240();
    }
    @Test
    public void testSpeedFactor(){
        assertEquals(volvo.speedFactor(),100 * 0.01 * 1.25, 0);
    }
    @Test
    public void testIncrementSpeedBelowEnginePower(){
        volvo.incrementSpeed(0.2);
        assertEquals(volvo.getCurrentSpeed(), 0 + 100 * 0.01 * 1.25 * 0.2, 0);
    }
    @Test
    public void testIncrementSpeedAboveEnginePower(){
        // Cheat to get speed over 100 but increment speed will never get
        // this high value form porgram
        volvo.incrementSpeed(101);
        assertEquals(volvo.getCurrentSpeed(), volvo.getEnginePower(), 0);
    }
    @Test
    public void testDecrementSpeedBelowZero(){
        volvo.decrementSpeed(0.1);
        assertEquals(volvo.getCurrentSpeed(), 0, 0);
    }
    @Test
    public void testDecrementSpeedAboveZero(){
        volvo.incrementSpeed(0.5);
        volvo.decrementSpeed(0.2);
        assertEquals(volvo.getCurrentSpeed(), 0.375, 0);
    }
}
