import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.awt.*;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestCar {

    @Parameters
    public static Iterable<Car> data() {

        return Arrays.asList(new Saab95(), new Volvo240());
    }

    private Car testCar;

    public TestCar(Car testcar) {
        this.testCar = testcar;
    }

    @Test
    public void testGetNrDoors() {
        assert testCar.nrDoors == testCar.getNrDoors();
    }

    @Test
    public void testGetEnginePower() {
        assert testCar.enginePower == testCar.getEnginePower();
    }

    @Test
    public void testGetCurrentSpeed() {
        assert testCar.currentSpeed == testCar.getCurrentSpeed();
    }

    @Test
    public void testGetPosition() {
        double[] position = {testCar.xPosition,testCar.yPosition};
        assert position == testCar.getPosition();
    }

    @Test
    public void testGetColor() {

        assert testCar.color == testCar.getColor();
    }

    @Test
    public void testSetColor() {
        testCar.setColor(Color.BLUE);
        assert testCar.color == Color.BLUE;

    }

    @Test
    public void testStartEngine() {
        testCar.startEngine();
        assert testCar.getCurrentSpeed() == 0.1;
    }

    @Test
    public void testStopEngine() {
        testCar.startEngine();
        testCar.stopEngine();
        assert testCar.getCurrentSpeed() == 0;
    }

    @Test
    public void testGetDirection() {
        assert testCar.direction == testCar.getDirection();
    }

    @Test
    public void testMove() {
        testCar.incrementSpeed(10);
        double speed = testCar.getCurrentSpeed();
        double dir = testCar.getDirection();
        testCar.move();
        assert (testCar.yPosition == speed * Math.sin(dir)) &&
                (testCar.xPosition == speed * Math.cos(dir));


    }

    @Test
    public void testTurnRight() {
        double dir = testCar.getDirection();
        double turnAmount = Math.PI / 3;
        testCar.turnRight(turnAmount);
        assert dir - turnAmount == testCar.getDirection();

    }

    @Test
    public void testTurnLeft() {
        double dir = testCar.getDirection();
        double turnAmount = Math.PI / 3;
        testCar.turnLeft(turnAmount);
        assert dir + turnAmount == testCar.getDirection();
    }

    @Test
    public void testGasNegativeValue() {
        testCar.gas(-10);
        assert testCar.getCurrentSpeed() == 0;
    }

    @Test
    public void testGasTooHighValue() {
        testCar.gas(20);
        double speed = testCar.getCurrentSpeed();

        testCar.currentSpeed = 0;

        testCar.incrementSpeed(1);

        assert speed == testCar.getCurrentSpeed();
    }

    @Test
    public void testGasLegalValue() {
        testCar.incrementSpeed(0.5);
        double speed = testCar.getCurrentSpeed();

        testCar.currentSpeed = 0;

        testCar.gas(0.5);
        assert speed == testCar.getCurrentSpeed();
    }

    @Test
    public void testBrakeNegativeValues() {
        testCar.currentSpeed = 20;
        testCar.brake(-10);
        assert testCar.getCurrentSpeed() == 20;

    }

    @Test
    public void testBrakeTooHighValues() {
        testCar.incrementSpeed(1);
        testCar.brake(20);
        assert testCar.getCurrentSpeed() == 0;
    }

    @Test
    public void testBrakeLegalValue() {
        testCar.incrementSpeed(1);
        testCar.brake(0.5);
        double speed = testCar.getCurrentSpeed();
        testCar.currentSpeed = 0;
        // testCar.currentSpeed
        testCar.incrementSpeed(0.5);

        assert speed == testCar.currentSpeed;
    }
}
