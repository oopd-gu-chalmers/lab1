import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestCar {
    Volvo240 volvo;
    @Before
    public void before(){
        volvo = new Volvo240();
    }

    @Test
    public void testGetNrDoors(){
        assertEquals(volvo.getNrDoors(), 4);
    }

    @Test
    public void testGetEnginePower(){
        assertEquals(volvo.getEnginePower(), 100, 0);
    }

    @Test
    public void testGetCurrentSpeed(){
        assertEquals(volvo.getCurrentSpeed(), 0, 0);
    }

    @Test
    public void testGetColor(){
        assertEquals(volvo.getColor(), Color.black);
    }

    @Test
    public void testSetColor(){
        volvo.setColor(Color.green);
        assertEquals(volvo.getColor(), Color.green);
    }

    @Test
    public void testGetModelName(){
        assertEquals(volvo.getModelName(), "Volvo240");
    }

    @Test
    public void testGetDirection(){
        assertEquals(volvo.getDirection(), "Forward");
    }
     @Test
    public void testGetPosition(){

        assertEquals(Arrays.toString(volvo.getPosition()), "[0.0, 0.0]");
     }
    @Test
    public void testStartEngine(){
        volvo.startEngine();
        assertEquals(volvo.getCurrentSpeed(), 0.1, 0);
    }

    @Test
    public void testStopEngine(){
        volvo.incrementSpeed(0.1);
        volvo.stopEngine();
        assertEquals(volvo.getCurrentSpeed(), 0, 0);
    }

    @Test
    public void testGasTrue(){
        volvo.gas(0.5);
        assertEquals(volvo.getCurrentSpeed(), 0.625, 0);
    }

    @Test
    public void testGasFalse(){
        volvo.gas(1.5);
        assertEquals(volvo.getCurrentSpeed(), 0, 0.0);
    }

    @Test
    public void testBrakeTrue(){
        volvo.brake(0.5);
        assertEquals(volvo.getCurrentSpeed(), 0, 0);
    }

    @Test
    public void testBrakeFalse(){
        volvo.brake(1.5);
        assertEquals(volvo.getCurrentSpeed(), 0, 0);
    }

    @Test
    public void testValueBetween0And1True(){
        assertTrue(volvo.valueBetween0And1(0.4));
    }

    @Test
    public void testValueBetween0And1FalseOver(){
        assertFalse(volvo.valueBetween0And1(1.4));
    }

    @Test
    public void testValueBetween0And1FalseUnder(){
        assertFalse(volvo.valueBetween0And1(-0.4));
    }

    @Test
    public void testTurnLeft(){
        volvo.turnLeft();
        assertEquals(volvo.getDirection(), "Left");
    }

    @Test
    public void testTurnRight(){
        volvo.turnRight();
        assertEquals(volvo.getDirection(), "Right");
    }

    @Test
    public void testMove(){
        double[] positionBefore = volvo.getPosition();
        volvo.move();
        Assert.assertArrayEquals(volvo.getPosition(), positionBefore, 0.0);
    }
}
