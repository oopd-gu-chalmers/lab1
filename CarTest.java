import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
     Volvo240 volvo240;
     Saab95 saab95;

    @BeforeEach
    void setUp() {
        volvo240 = new Volvo240();
        saab95 = new Saab95();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNrDoors() {
        assertEquals(4, volvo240.getNrDoors());
        assertEquals(2, saab95.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(100, volvo240.getEnginePower());
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
    }

    @Test
    void stopEngine() {
    }

    @Test
    void speedfactor() {
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void move() {
    }

    @Test
    void turnLeft() {
    }

    @Test
    void turnRight() {
    }
}