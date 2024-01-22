import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {
    public CarTest() {
        volvocar = new car(4, 100, Color.black, "Volvo240");
        sabcar = new car(2, 125, Color.red, "Saab95");
    }

    car volvocar;
    car sabcar;
    @Test
    public void getNrDoors() {
        assertEquals(4, volvocar.getNrDoors());
        assertEquals(2, sabcar.getNrDoors());
    }

    @Test
    public void getEnginePower() {
        assertEquals(100, volvocar.getEnginePower(), 0.0001);
    }

    @Test
    public void getCurrentSpeed() {
        volvocar.startEngine();
        assertEquals(0.1, volvocar.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void getColor() {
        assertEquals(Color.black, volvocar.getColor());
    }

    @Test
    public void setColor() {
        volvocar.setColor(Color.black);
        assertEquals(Color.black, volvocar.getColor());
    }

    @Test
    public void startEngine() {
        volvocar.startEngine();
        assertEquals(0.1, volvocar.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void stopEngine() {
        volvocar.stopEngine();
        assertEquals(0.0, volvocar.getCurrentSpeed(), 0.0001);
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