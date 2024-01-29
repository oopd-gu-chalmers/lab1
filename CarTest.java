
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {
    Volvo240 volvocar;
    Saab95 sabcar;
   @Before
    public void setUp() {
        volvocar = new Volvo240();
        sabcar = new Saab95();
    }

    @Test
    public void getNrDoors() {
        assertEquals(4, volvocar.getNrDoors());
        assertEquals(2, sabcar.getNrDoors());
    }

    @Test
    public void getEnginePower() {
        assertEquals(100, volvocar.getEnginePower(), 0.0001);
        assertEquals(125, sabcar.getEnginePower(), 0.0001);

    }

    @Test
    public void getCurrentSpeed() {
        volvocar.startEngine();
        assertEquals(0.1, volvocar.getCurrentSpeed(), 0.0001);
        sabcar.startEngine();
        assertEquals(0.1, sabcar.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void getColor() {
        assertEquals(Color.black, volvocar.getColor());
        assertEquals(Color.red, sabcar.getColor());
    }

    @Test
    public void setColor() {
        volvocar.setColor(Color.black);
        assertEquals(Color.black, volvocar.getColor());
        sabcar.setColor(Color.red);
        assertEquals(Color.red, sabcar.getColor());
    }

    @Test
    public void startEngine() {
        volvocar.startEngine();
        assertEquals(0.1, volvocar.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void stopEngine() {
        sabcar.stopEngine();
        assertEquals(0.0, sabcar.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void move() {
        volvocar.startEngine();
        volvocar.move();
        assertEquals(0.1, volvocar.getCurrentSpeed(), 0.0001);
        sabcar.startEngine();
        sabcar.move();
        assertEquals(0.1, sabcar.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void turnLeft() {
        volvocar.setDirection(0);
        if (volvocar.getDirection() == 0) {
            volvocar.setDirection(4);
        }
        volvocar.turnleft();
        assertEquals(3, volvocar.getDirection());

    }

    @Test
    public void turnRight() {
        volvocar.setDirection(4);
        if (volvocar.getDirection() == 4) {
            volvocar.setDirection(-1);
        }
        volvocar.turnright();
        assertEquals(0, volvocar.getDirection());
    }
    @Test
    public void gasVolvo() {
        //amount is higher than 1
        volvocar.gas(1.01);
        assertEquals(0.0, volvocar.getCurrentSpeed(), 0.0001);
        //checks if speed is increasing and speed dosent lower when you gas
        double e = volvocar.getCurrentSpeed();
        volvocar.gas(0.2);
        assertEquals(0.25, volvocar.getCurrentSpeed(), 0.0001);
        assertTrue(volvocar.getCurrentSpeed() >= e);
        //speed limit
        volvocar.setCurrentSpeed(99.99);
        volvocar.gas(1);
        assertEquals(100, volvocar.getCurrentSpeed(), 0.0001);
    }
            @Test
            public void gasSab() {
                //amount is higher than 1
                sabcar.gas(1.01);
            assertEquals(0.0, sabcar.getCurrentSpeed(), 0.0001);
                //checks if speed is increasing and speed dosent lower when you gas
            double f = sabcar.getCurrentSpeed();
            sabcar.gas(0.2);
            assertEquals(0.25, sabcar.getCurrentSpeed(), 0.0001);
            assertTrue(sabcar.getCurrentSpeed() >= f);
                //speed limit
            sabcar.setCurrentSpeed(124.99);
            sabcar.gas(1);
            assertEquals(125, sabcar.getCurrentSpeed(), 0.0001);
        }


    @Test
    public void brakeVolvo() {
        try {
            //amount lower than 0
            volvocar.brake(-0.01);
        } catch (IllegalArgumentException e) {
            System.out.println("amount to low");
        }
        //check if speed is lower, and speed dosent get higher.
        volvocar.setCurrentSpeed(1);
        double e = volvocar.getCurrentSpeed();
        volvocar.brake(0.2);
        assertEquals(0.75, volvocar.getCurrentSpeed(), 0.0001);
        assertTrue(volvocar.getCurrentSpeed() <= e);
        // speed cant be lower than 0
        volvocar.setCurrentSpeed(0.01);
        volvocar.brake(0.9);
        assertEquals(0, volvocar.getCurrentSpeed(), 0.0001);
    }
        @Test
        public void brakeSab() {
            try {
                //amount lower than 0
                sabcar.brake(-0.01);
            } catch (IllegalArgumentException e) {
                System.out.println("amount is to low");
            }
            //check if speed is lower, and speed dosent get higher.
            sabcar.setCurrentSpeed(1);
            double f = sabcar.getCurrentSpeed();
            sabcar.brake(0.2);
            assertEquals(0.75, sabcar.getCurrentSpeed(), 0.0001);
            assertTrue(sabcar.getCurrentSpeed() <= f);
            // speed cant be lower than 0
            sabcar.setCurrentSpeed(0.01);
            sabcar.brake(0.9);
            assertEquals(0, sabcar.getCurrentSpeed(), 0.0001);
        }
        @Test
        public void turboOn() {
            sabcar.setTurboOn();
            assertTrue(sabcar.getTurbo());
        }
        @Test
            public void turboOff() {
            sabcar.setTurboOff();
            assertFalse(sabcar.getTurbo());
        }
        @Test
        public void raiseFlak() {
            //raise flak with 5
            Scania scania = new Scania();
            scania.raiseFlak();
            assertEquals(5, scania.getAngleFlak(), 0.0001);
            // cant raise more than 70
            scania.setAngleFLak(69);
            scania.raiseFlak();
            assertEquals(70, scania.getAngleFlak(),0.0001);
            //cant raise flak while car is moving
            scania.setDirection(40);
            try {
                scania.raiseFlak();
            } catch (IllegalArgumentException e) {
                System.out.println("car is moving");
            }

        }

        @Test
        public void lowerFlak() {
            // lower flak with 5
            Scania scania = new Scania();
            scania.setAngleFLak(5);
            scania.lowerFlak();
            assertEquals(0, scania.getAngleFlak(), 0.0001);
            // cant lower more than 0
            scania.lowerFlak();
            assertEquals(0, scania.getAngleFlak(),0.0001);
            //cant lower flak while car is moving
            scania.setCurrentSpeed(40);
            try {
                scania.lowerFlak();
            } catch (IllegalArgumentException e) {
                System.out.println("car is moving");
            }
        }

}