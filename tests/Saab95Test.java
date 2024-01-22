import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    private Saab95 saab;
    @BeforeEach
    void setUp() {
        saab = new Saab95();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNrDoors() {
    }

    @Test
    void getEnginePower() {
    }

    @Test
    void getCurrentSpeed() {
    }

    @Test
    void getColor() {
        assertEquals(saab.getColor(), Color.red);
    }

    @Test
    void setColor() {
        saab.setColor(Color.blue);
        assertEquals(saab.getColor(), Color.blue);
    }

    @Test
    void startEngine() {
    }

    @Test
    void stopEngine() {
    }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }

    @Test
    void move() {
    }

    @Test
    void turnLeft() {
        saab.turnLeft(30);
        assertEquals(saab.getDirection(), 30);
        saab.turnLeft(390);
        assertEquals(saab.getDirection(), 60);
    }

    @Test
    void turnRight() {
        saab.turnRight(30);
        assertEquals(saab.getDirection(), -30);
        saab.turnRight(390);
        assertEquals(saab.getDirection(), -60);
    }

    @Test
    void setTurboOn() {
    }

    @Test
    void setTurboOff() {
    }

    @Test
    void speedFactor() {
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }

    @Test
    void getDirection() {
        assertEquals(saab.getDirection(), 0);
    }
}