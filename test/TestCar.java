
import assets.elements.vehicles.cars.PassengerCar;
import assets.elements.vehicles.cars.passengerCars.Volvo240;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestCar {
    private static class CursedCar extends PassengerCar {
        private final double cursedSpeedFactor;
        public CursedCar(double cursedSpeedFactor){
            super(-1, 0,100, "😎", Color.MAGENTA);
            this.cursedSpeedFactor = cursedSpeedFactor;
        }
        protected double intrinsicSpeedFactor(){
            return cursedSpeedFactor;
        }
    }

    Volvo240 volvo;
    CursedCar carWithSpeedFactorNegative;
    CursedCar carWithSpeedFactorVeryLarge;
    @Before
    public void initCars(){
        volvo = new Volvo240();
        carWithSpeedFactorNegative = new CursedCar(-69.420);
        carWithSpeedFactorVeryLarge = new CursedCar(69420);
    }

    @Test
    public void volvoDoorNrShouldBe4(){
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void volvoEnginePowerShouldBe100(){
        assertEquals(100, volvo.getEnginePower(), 0.001);
    }

    @Test
    public void carSpeedShouldInitAt0(){
        assertEquals(0, volvo.getSpeed(), 0.001);
    }

    @Test
    public void volvoColorShouldInitBlack(){
        assertEquals(Color.black, volvo.getColor());
    }

    @Test
    public void testCarSetColor(){
        volvo.setColor(Color.green);
        assertEquals(Color.green,volvo.getColor());
    }

    @Test
    public void testVolvoGetModelName(){
        assertEquals( "Elements.Volvo240", volvo.getModelName());
    }

    @Test
    public void casRotationShouldInitAt0(){
        assertEquals(0, volvo.getRotation(), 0.001);
    }
     @Test
    public void carPositionShouldInitAtOrigin(){
        assertEquals("[0.0, 0.0]", Arrays.toString(volvo.getPosition()));
     }
    @Test
    public void carStartEngineShouldSetSpeedTo0Point1(){
        volvo.startEngine();
        assertEquals(0.1, volvo.getSpeed(), 0.001);
    }

    @Test
    public void carStopEngineShouldSetSpeedTo0(){
        volvo.startEngine();
        volvo.gas(1);
        volvo.stopEngine();
        assertEquals(0, volvo.getSpeed(), 0.001);
    }

    @Test
    public void carGasShouldIncreaseSpeed(){
        volvo.startEngine();
        volvo.gas(0.5);
        assertTrue(volvo.getSpeed() > 0.2);
    }

    @Test
    public void carGasShouldNotGoAbove1(){
        volvo.startEngine();
        volvo.gas(1.5);
        assertEquals(0.1, volvo.getSpeed(), 0.0);
    }

    @Test
    public void carBrakeShouldDecreaseSpeed(){
        volvo.startEngine();
        volvo.gas(1);
        double highSpeed = volvo.getSpeed();
        volvo.brake(0.5);
        assertTrue(volvo.getSpeed() < highSpeed);
    }

    @Test
    public void carBrakeShouldNotGoAbove1(){
        volvo.startEngine();
        volvo.gas(1);
        double highSpeed = volvo.getSpeed();
        volvo.brake(1.5);
        assertEquals(highSpeed,volvo.getSpeed(), 0.001);
    }
    @Test
    public void testTurnLeft(){
        volvo.turnLeft(90);
        assertEquals(270, volvo.getRotation(),0.001);
    }

    @Test
    public void testTurnRight(){
        volvo.turnRight(45);
        assertEquals(45, volvo.getRotation(), 0.001);
    }

    @Test
    public void volvoShouldMoveToTheLeftAt90DegTurn(){
        volvo.startEngine();
        volvo.turnLeft(90);
        volvo.moveTick();
        assertTrue(volvo.getPosition()[0] < 0 && Math.abs(volvo.getPosition()[1]) < 0.001);
    }
    @Test
    public void testIncrementSpeedBelowEnginePower(){
        volvo.startEngine();
        volvo.gas(1);
        assertTrue(volvo.getSpeed() > 0 && volvo.getSpeed() < volvo.getEnginePower());
    }
    @Test
    public void testIncrementSpeedAboveEnginePower(){
        carWithSpeedFactorVeryLarge.startEngine();
        carWithSpeedFactorVeryLarge.gas(1);
        assertEquals(carWithSpeedFactorVeryLarge.getEnginePower(), carWithSpeedFactorVeryLarge.getSpeed(), 0.001);
    }

    @Test
    public void testDecrementSpeedBelowZero(){
        volvo.brake(0.1);
        assertEquals(0, volvo.getSpeed(), 0.001);
    }
    @Test
    public void testDecrementSpeedAboveZero(){
        volvo.startEngine();
        volvo.gas(0.5);
        double highSpeed = volvo.getSpeed();
        volvo.brake(0.1);
        assertTrue(volvo.getSpeed() > 0 && volvo.getSpeed() < highSpeed);
    }
}
