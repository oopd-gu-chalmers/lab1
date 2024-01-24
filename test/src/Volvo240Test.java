package src;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    private Volvo240 volvo;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        volvo = new Volvo240();
    }

    @org.junit.jupiter.api.Test
    void getNrDoors() {
        assertEquals(4, volvo.getNrDoors());
    }

    @org.junit.jupiter.api.Test
    void getEnginePower() {
        assertEquals(100, volvo.getEnginePower());
    }

    @org.junit.jupiter.api.Test
    void getCurrentSpeed() {
        assertEquals(volvo.getCurrentSpeed(), volvo.currentSpeed);
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        assertEquals(volvo.getColor(), volvo.color);
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        volvo.setColor(Color.BLUE);
        assertEquals(volvo.getColor(), Color.BLUE);
    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        volvo.startEngine();
        assertEquals(volvo.getCurrentSpeed(), 0.1);
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        volvo.startEngine();
        volvo.stopEngine();
        assertEquals(volvo.getCurrentSpeed(), 0);
    }

    @org.junit.jupiter.api.Test
    void move() {
        Point tmp1 = volvo.point;
        volvo.startEngine();
        volvo.move();
        assertNotEquals(volvo.point, tmp1);
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        Point tmp1 = volvo.direction;
        volvo.turnLeft();
        Point turnedtmp1 = new Point(-tmp1.y, tmp1.x);
        assertEquals(turnedtmp1, volvo.direction);
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        Point tmp1 = volvo.direction;
        volvo.turnLeft();
        Point turnedtmp1 = new Point(tmp1.y, -tmp1.x);
        assertEquals(turnedtmp1, volvo.direction);
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
        double tmp1 = volvo.getCurrentSpeed();
        volvo.incrementSpeed(1);
        assertNotEquals(tmp1, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void decrementSpeed() {
        double tmp1 = volvo.getCurrentSpeed();
        volvo.decrementSpeed(1);
        assertNotEquals(tmp1, volvo.getCurrentSpeed());
    }
}
