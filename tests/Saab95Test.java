import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void setColor() {
    }

    @Test
    void startEngine() {
        saab.stopEngine();
        saab.startEngine();
        assertNotEquals(saab.currentSpeed,0);
    }

    @Test
    void stopEngine() {
        saab.startEngine();
        saab.stopEngine();
        assertEquals(saab.currentSpeed,0);
    }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }

    @Test
    void move() {
        Position positionBeforeMove;
        positionBeforeMove = new Position(saab.getPosition().get_x(), saab.getPosition().get_y());
        saab.startEngine();

        saab.move();
        assertNotEquals(positionBeforeMove.get_x(), saab.getPosition().get_x());

        saab.turnLeft(180);
        saab.move();
        assertEquals(positionBeforeMove.get_x(), saab.getPosition().get_x());

    }

    @Test
    void turnLeft() {
    }

    @Test
    void turnRight() {
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
    void getPosition() {
    }

}