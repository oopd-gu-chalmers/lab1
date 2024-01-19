import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class carTest {
    public carTest() {
        testcar = new car(4, 100, Color.black, "Volvo240");
    }

    car testcar;
    @Test
    public void getNrDoors() {
        assertEquals(4, testcar.getNrDoors());
    }

    @Test
    public void getEnginePower() {
        assertEquals(100, testcar.getEnginePower(), 00001);
    }

    @Test
    public void getCurrentSpeed() {
        assertEquals(testcar.currentSpeed, testcar.getCurrentSpeed());
    }

    @Test
    public void getColor() {
        assertEquals(Color.black, testcar.getColor());
    }

    @Test
    public void setColor() {

    }

    @Test
    public void startEngine() {
    }

    @Test
    public void stopEngine() {
    }

    @Test
    public void move() {
    }

    @Test
    public void turnleft() {
    }

    @Test
    public void turnright() {
    }
}