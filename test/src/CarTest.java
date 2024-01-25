package src;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Saab95 saab;
    private Volvo240 volvo;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

    }
    @org.junit.jupiter.api.Test
    void getNrDoors() {
        assert saab.getNrDoors() == 2;
        assert volvo.getNrDoors() == 4;
    }

    @org.junit.jupiter.api.Test
    void getEnginePower() {

        assert saab.getEnginePower() == 125;
        assert volvo.getEnginePower() == 100;
    }

    @org.junit.jupiter.api.Test
    void getCurrentSpeed() {
        assert saab.getCurrentSpeed() == saab.currentSpeed;
        assert volvo.getCurrentSpeed() == volvo.currentSpeed;
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        assert saab.getColor() == saab.color;
        assert volvo.getColor() == volvo.color;
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        saab.setColor(Color.BLUE);
        assert saab.getColor() == Color.BLUE;
        volvo.setColor(Color.BLUE);
        assert saab.getColor() == Color.BLUE;

    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        saab.startEngine();
        volvo.startEngine();
        assert saab.getCurrentSpeed() == 0.1;
        assert volvo.getCurrentSpeed() == 0.1;
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        saab.startEngine();
        volvo.startEngine();
        saab.stopEngine();
        volvo.stopEngine();
        assert saab.getCurrentSpeed() == 0;
        assert volvo.getCurrentSpeed() == 0;
    }

    @org.junit.jupiter.api.Test
    void move() {
        Point tmp1 = saab.point;
        Point tmp2 = volvo.point;
        saab.startEngine();
        volvo.startEngine();
        saab.move();
        volvo.move();
        assert saab.point != tmp1;
        assert volvo.point != tmp2;
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        Point tmp1 = saab.direction;
        Point tmp2 = volvo.direction;
        saab.turnLeft();
        volvo.turnLeft();
        Point turnedtmp1 = new Point (-tmp1.y, tmp1.x);
        Point turnedtmp2 = new Point (-tmp2.y, tmp2.x);
        assert turnedtmp1.equals(saab.direction);
        assert turnedtmp2.equals(volvo.direction);
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        Point tmp1 = saab.direction;
        Point tmp2 = volvo.direction;
        saab.turnLeft();
        volvo.turnLeft();
        Point turnedtmp1 = new Point (tmp1.y, -tmp1.x);
        Point turnedtmp2 = new Point (tmp2.y, -tmp2.x);
        assert turnedtmp1.equals(saab.direction);
        assert turnedtmp2.equals(volvo.direction);
    }
    @org.junit.jupiter.api.Test
    void incrementspeed() {
        double tmp1 = saab.getCurrentSpeed();
        double tmp2 = volvo.getCurrentSpeed();
        saab.incrementSpeed(1);
        volvo.incrementSpeed(1);
        assert tmp1 != saab.getCurrentSpeed();
        assert tmp2 != volvo.getCurrentSpeed();
    }
    @org.junit.jupiter.api.Test
    void decremementspeed() {
        double tmp1 = saab.getCurrentSpeed();
        double tmp2 = volvo.getCurrentSpeed();
        saab.decrementSpeed(1);
        volvo.decrementSpeed(1);
        assert tmp1 != saab.getCurrentSpeed();
        assert tmp2 != volvo.getCurrentSpeed();
    }

}