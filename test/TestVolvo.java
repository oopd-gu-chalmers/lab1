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
        volvo.gas(0.2);
        assertEquals(volvo.getCurrentSpeed(), 0 + 100 * 0.01 * 1.25 * 0.2, 0);
    }
    @Test
    public void testIncrementSpeedAboveEnginePower(){
        // Cheat to get speed over 100 but increment speed will never get
        // this high value form porgram
        for (int i = 0; i <= 100; i++){
            volvo.gas(0.9);
        }
        assertEquals(volvo.getCurrentSpeed(), volvo.getEnginePower(), 0);
    }
    @Test
    public void testDecrementSpeedBelowZero(){
        volvo.brake(0.1);
        assertEquals(volvo.getCurrentSpeed(), 0, 0);
    }
    @Test
    public void testDecrementSpeedAboveZero(){
        volvo.gas(0.5);
        volvo.gas(0.2);
        assertEquals(volvo.getCurrentSpeed(), 0.875, 0);
    }
}
