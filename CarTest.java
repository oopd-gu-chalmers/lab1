
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarTest {
    Volvo240 volvocar;
    Saab95 sabcar;
    BilTransport bilTransport;
    Scania scania;
    Verkstad <Volvo240> verkstadMedVolvo;
    Verkstad <Truck> verkstadMedAllaTrucks;
   @Before
    public void setUp() {
        this.volvocar = new Volvo240();
        this.sabcar = new Saab95();
        this.scania = new Scania();
        this.bilTransport = new BilTransport();
        this.verkstadMedVolvo = new Verkstad<>(2, new ArrayList<>());
        this.verkstadMedAllaTrucks = new Verkstad<>(2, new ArrayList<>());
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
        assertEquals(0, volvocar.getDirection());
        volvocar.turnleft();
        assertEquals(1, volvocar.getDirection());
        volvocar.turnleft();
        assertEquals(2, volvocar.getDirection());
        volvocar.turnleft();
        assertEquals(3, volvocar.getDirection());
        volvocar.turnleft();
        assertEquals(4, volvocar.getDirection());
    }

    @Test
    public void turnRight() {
        volvocar.setDirection(4);
        if (volvocar.getDirection() == 4) {
            volvocar.setDirection(-1);
        }
        volvocar.turnright();
        assertEquals(4, volvocar.getDirection());
        volvocar.turnright();
        assertEquals(3, volvocar.getDirection());
        volvocar.turnright();
        assertEquals(2, volvocar.getDirection());
        volvocar.turnright();
        assertEquals(1, volvocar.getDirection());

    }

    @Test
    public void gasVolvo() {
        //amount is higher than 1
        volvocar.gas(1.01);
        assertEquals(0.0, volvocar.getCurrentSpeed(), 0.0001);
        //checks if speed is increasing and speed doesn't decrease when you gas
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
        //checks if speed is increasing and speed doesn't decrease when you gas
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
        //check if speed is lower, and speed doesn't get higher.
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
        public void raiseRamp() {
            //raise flak with 5
            scania.raiseRamp();
            assertEquals(10, scania.getRamp().getAngle(), 0.001);
            // cant raise more than 70
            scania.getRamp().angleSet(70);
            scania.raiseRamp();
            assertEquals(70, scania.getRamp().getAngle(),0.001);
            //cant raise flak while car is moving
            scania.setDirection(40);
            try {
                scania.raiseRamp();
            } catch (IllegalArgumentException e) {
                System.out.println("car is moving");
            }

            // Same tests with BilTransport
            bilTransport.raiseRamp();
            assertTrue(bilTransport.getRamp().getRampState());
        }

        @Test
        public void lowerRamp() {
            // lower flak with 10
            scania.getRamp().angleSet(10);
            scania.lowerRamp();
            assertEquals(0, scania.getRamp().getAngle(), 0.001);
            // cant lower more than 0
            scania.lowerRamp();
            assertEquals(0, scania.getRamp().getAngle(),0.001);
            //cant lower flak while car is moving
            scania.setCurrentSpeed(40);
            try {
                scania.lowerRamp();
            } catch (IllegalArgumentException e) {
                System.out.println("Scania is moving");
            }

            // Same tests with BilTransport
            bilTransport.lowerRamp();
            assertFalse(bilTransport.getRamp().getRampState());
        }

        @Test
        public void loadOn() {
            // Kollar ifall den läggs till i verkstaden.
            verkstadMedVolvo.loadOn(volvocar);
            //verkstadMedVolvo.loadOn(sabcar);
            assertEquals(1, verkstadMedVolvo.getCapacity());

            // Kollar om det fungerar att lägga till olika typer.
            verkstadMedAllaTrucks.loadOn(scania);
            verkstadMedAllaTrucks.loadOn(bilTransport);
            //verkstadMedAllaTrucks.loadOn(volvocar);
            assertEquals(2, verkstadMedAllaTrucks.getCapacity());
        }

        @Test
        public void unLoadCar() {
            verkstadMedVolvo.loadOn(volvocar);
            verkstadMedAllaTrucks.loadOn(scania);

            // Kollar om det går med en Volvo-verkstad
            verkstadMedVolvo.unLoadCar(volvocar);
            //verkstadMedVolvo.unLoadCar(sabcar);
            assertEquals(0, verkstadMedVolvo.getCapacity());

            // Kollar om det går för en verkstad med alla typer av lastbilar.
            verkstadMedAllaTrucks.unLoadCar(scania);
            assertEquals(0, verkstadMedAllaTrucks.getCapacity());
        }

    @Test
    public void loadCar() {
        bilTransport.lowerRamp();
        bilTransport.loadCar(volvocar);
        bilTransport.loadCar(sabcar);
        assertEquals(2, bilTransport.getFlak().size());

        //more than MAX_LOAD
        bilTransport.loadCar(volvocar);
        bilTransport.loadCar(volvocar);
        bilTransport.loadCar(sabcar);
        try {
            bilTransport.loadCar(volvocar);
        } catch (IllegalArgumentException e) {
            System.out.println("reached full capacity");
        }
    }

    @Test
    public void unloadCar(){
        bilTransport.lowerRamp();
        bilTransport.loadCar(volvocar);
        bilTransport.loadCar(sabcar);
        bilTransport.unLoadCar();
        assertEquals(1, bilTransport.getFlak().size());
        assertTrue(bilTransport.getFlak().peek().equals(volvocar));
    }

    @Test
    public void getAngleFlak(){
       scania.getRamp().angleSet(0);
        assertEquals(0, scania.getRamp().getAngle(), 0.001);
    }

    @Test
    public void setAngleFLak(){
        scania.getRamp().angleSet(20);
        assertEquals(20, scania.getRamp().getAngle(), 0.001);
    }

    @Test
    public void truckGas(){
        scania.gas(0.2);
        // flak is 50 cant gas
        bilTransport.getRamp().angleSet(50);
        try {
            bilTransport.gas(0.2);
        } catch (IllegalArgumentException e) {
            System.out.println("flak is not 0 cant gas");
        }
    }

    @Test
    public void decrementSpeed(){
        scania.setCurrentSpeed(50);
        scania.decrementSpeed(10);
        assertEquals(46.0, scania.getCurrentSpeed(), 0.0001);
    }
    @Test
    public void getRampState () {
       scania.getRamp().setRampState(true);
       assertTrue(scania.getRamp().getRampState());
    }

    @Test
    public void moveTruck() {

    }
}