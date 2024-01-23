import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car saab;
    private Car volvo;

    @org.junit.jupiter.api.BeforeEach //konstruktor för testklassen?
    void setUp() {
        this.saab = new Saab95();
        this.volvo = new Volvo240();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getNrDoors() {
        assertEquals(2, saab.getNrDoors());
        assertEquals(4, volvo.getNrDoors());
    }

    @org.junit.jupiter.api.Test
    void getEnginePower() {
        assertEquals(125, saab.getEnginePower());
        assertEquals(100, volvo.getEnginePower());
    }

    @org.junit.jupiter.api.Test
    void getCurrentSpeed() {
        assertEquals(0, saab.getCurrentSpeed());
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        assertEquals(Color.red, saab.getColor());
        assertEquals(Color.black, volvo.getColor());
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        saab.setColor(Color.pink);
        volvo.setColor(Color.cyan);

        assertEquals(Color.pink, saab.getColor());
        assertEquals(Color.cyan, volvo.getColor());
    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        saab.startEngine();
        volvo.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed());
        assertEquals(0.1, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        saab.startEngine();
        volvo.startEngine();
        saab.stopEngine();
        volvo.stopEngine();
        assertEquals(0, saab.getCurrentSpeed());
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void setPosition() {
    }

    @org.junit.jupiter.api.Test
    void getPosition() {
        assertEquals(0, saab.getPosition().getX());
        assertEquals(0, saab.getPosition().getY());
        assertEquals(0, volvo.getPosition().getX());
        assertEquals(0, volvo.getPosition().getY());

    }

    @org.junit.jupiter.api.Test
    void setDirection() {
    }

    @org.junit.jupiter.api.Test
    void getDirection() {
        saab.turnLeft();
        volvo.turnLeft();
        assertEquals(-90, saab.getDirection());
        assertEquals(-90, volvo.getDirection());
    }

    @org.junit.jupiter.api.Test
    void gas() {
        //currentspeed is defaulted to 0 here
        //would like to test saab.setTurboOn();, saab.setTurboOff(); here aswell but cannot access them here sadly
        saab.gas(0.5);
        volvo.gas(0.5);
        assertEquals(0.625, saab.getCurrentSpeed());
        assertEquals(0.625, volvo.getCurrentSpeed()); //0,01*1,25*100 is same as 0,01

    }

    @org.junit.jupiter.api.Test
    void brake() {
    }

    @org.junit.jupiter.api.Test
    void move() {
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        saab.turnLeft();
        volvo.turnLeft();
        assertEquals(-90, saab.getDirection());
        assertEquals(-90, volvo.getDirection());
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        saab.turnRight();
        volvo.turnRight();
        assertEquals(90, saab.getDirection());
        assertEquals(90, volvo.getDirection());
    }

    @org.junit.jupiter.api.Test
    void speedFactor() {
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
    }

    @org.junit.jupiter.api.Test
    void decrementSpeed() {
    }
}