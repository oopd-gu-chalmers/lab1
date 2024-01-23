import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    private Saab95 saab;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        saab = new Saab95();
    }

    @org.junit.jupiter.api.Test
    void getNrDoors() {
        assertEquals(4, saab.getNrDoors());
    }

    @org.junit.jupiter.api.Test
    void getEnginePower() {
        assertEquals(125, saab.getEnginePower());
    }

    @org.junit.jupiter.api.Test
    void getCurrentSpeed() {
        assertEquals(saab.getCurrentSpeed(), saab.currentSpeed);
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        assertEquals(saab.getColor(), saab.color);
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        saab.setColor(Color.BLUE);
        assertEquals(saab.getColor(), Color.BLUE);
    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        saab.startEngine();
        assertEquals(saab.getCurrentSpeed(), 0.1);
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        saab.startEngine();
        saab.stopEngine();
        assertEquals(saab.getCurrentSpeed(), 0);
    }

    @org.junit.jupiter.api.Test
    void move() {
        Point tmp1 = saab.point;
        saab.startEngine();
        saab.move();
        assertNotEquals(saab.point, tmp1);
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        Point tmp1 = saab.direction;
        saab.turnLeft();
        Point turnedtmp1 = new Point(-tmp1.y, tmp1.x);
        assertEquals(turnedtmp1, saab.direction);
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        Point tmp1 = saab.direction;
        saab.turnLeft();
        Point turnedtmp1 = new Point(tmp1.y, -tmp1.x);
        assertEquals(turnedtmp1, saab.direction);
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
        double tmp1 = saab.getCurrentSpeed();
        saab.incrementSpeed(1);
        assertNotEquals(tmp1, saab.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void decrementSpeed() {
        double tmp1 = saab.getCurrentSpeed();
        saab.decrementSpeed(1);
        assertNotEquals(tmp1, saab.getCurrentSpeed());
    }
}
