
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarTest {
    Volvo240 volvo;
    Saab95 saab;
    BilTransport bilTransport;
    Scania scania;
    Verkstad <Volvo240> verkstadMedVolvo;
    Verkstad <Car> verkstadMedAllaTrucks;
   @Before
    public void setUp() {
        this.volvo = new Volvo240();
        this.saab = new Saab95();
        this.scania = new Scania();
        this.bilTransport = new BilTransport();
        this.verkstadMedVolvo = new Verkstad<>(2, new ArrayList<>());
        this.verkstadMedAllaTrucks = new Verkstad<>(2, new ArrayList<>());
    }

    @Test
    public void getNrDoors() {
        assertEquals(4, volvo.getNrDoors());
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void getEnginePower() {
        assertEquals(100, volvo.getEnginePower(), 0.0001);
        assertEquals(125, saab.getEnginePower(), 0.0001);

    }

    @Test
    public void getCurrentSpeed() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.0001);
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void getColor() {
        assertEquals(Color.black, volvo.getColor());
        assertEquals(Color.red, saab.getColor());
    }

    @Test
    public void setColor() {
        volvo.setColor(Color.black);
        assertEquals(Color.black, volvo.getColor());
        saab.setColor(Color.red);
        assertEquals(Color.red, saab.getColor());
    }

    @Test
    public void startEngine() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void stopEngine() {
        saab.stopEngine();
        assertEquals(0.0, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void move() {
        volvo.startEngine();
        volvo.move();
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.0001);
        saab.startEngine();
        saab.move();
        assertEquals(0.1, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void turnLeft() {
        volvo.setDirection(0);
        if (volvo.getDirection() == 0) {
            volvo.setDirection(4);
        }
        volvo.turnleft();
        assertEquals(0, volvo.getDirection());
        volvo.turnleft();
        assertEquals(1, volvo.getDirection());
        volvo.turnleft();
        assertEquals(2, volvo.getDirection());
        volvo.turnleft();
        assertEquals(3, volvo.getDirection());
        volvo.turnleft();
        assertEquals(4, volvo.getDirection());
    }

    @Test
    public void turnRight() {
        volvo.setDirection(4);
        if (volvo.getDirection() == 4) {
            volvo.setDirection(-1);
        }
        volvo.turnright();
        assertEquals(4, volvo.getDirection());
        volvo.turnright();
        assertEquals(3, volvo.getDirection());
        volvo.turnright();
        assertEquals(2, volvo.getDirection());
        volvo.turnright();
        assertEquals(1, volvo.getDirection());

    }

    @Test
    public void gasVolvo() {
        //amount is higher than 1
        volvo.gas(1.01);
        assertEquals(0.0, volvo.getCurrentSpeed(), 0.0001);
        //checks if speed is increasing and speed doesn't decrease when you gas
        double e = volvo.getCurrentSpeed();
        volvo.gas(0.2);
        assertEquals(0.25, volvo.getCurrentSpeed(), 0.0001);
        assertTrue(volvo.getCurrentSpeed() >= e);
        //speed limit
        volvo.setCurrentSpeed(99.99);
        volvo.gas(1);
        assertEquals(100, volvo.getCurrentSpeed(), 0.0001);
    }
    @Test
    public void gasSab() {
        //amount is higher than 1
        saab.gas(1.01);
        assertEquals(0.0, saab.getCurrentSpeed(), 0.0001);
        //checks if speed is increasing and speed doesn't decrease when you gas
        double f = saab.getCurrentSpeed();
        saab.gas(0.2);
        assertEquals(0.25, saab.getCurrentSpeed(), 0.0001);
        assertTrue(saab.getCurrentSpeed() >= f);
        //speed limit
        saab.setCurrentSpeed(124.99);
        saab.gas(1);
        assertEquals(125, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void brakeVolvo() {
        try {
            //amount lower than 0
            volvo.brake(-0.01);
        } catch (IllegalArgumentException e) {
            System.out.println("amount to low");
        }
        //check if speed is lower, and speed doesn't get higher.
        volvo.setCurrentSpeed(1);
        double e = volvo.getCurrentSpeed();
        volvo.brake(0.2);
        assertEquals(0.75, volvo.getCurrentSpeed(), 0.0001);
        assertTrue(volvo.getCurrentSpeed() <= e);
        // speed cant be lower than 0
        volvo.setCurrentSpeed(0.01);
        volvo.brake(0.9);
        assertEquals(0, volvo.getCurrentSpeed(), 0.0001);
    }
        @Test
        public void brakeSab() {
            try {
                //amount lower than 0
                saab.brake(-0.01);
            } catch (IllegalArgumentException e) {
                System.out.println("amount is to low");
            }
            //check if speed is lower, and speed doesn't get higher.
            saab.setCurrentSpeed(1);
            double f = saab.getCurrentSpeed();
            saab.brake(0.2);
            assertEquals(0.75, saab.getCurrentSpeed(), 0.0001);
            assertTrue(saab.getCurrentSpeed() <= f);
            // speed cant be lower than 0
            saab.setCurrentSpeed(0.01);
            saab.brake(0.9);
            assertEquals(0, saab.getCurrentSpeed(), 0.0001);
        }
        @Test
        public void turboOn() {
            saab.setTurboOn();
            assertTrue(saab.getTurbo());
        }
        @Test
            public void turboOff() {
            saab.setTurboOff();
            assertFalse(saab.getTurbo());
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
            verkstadMedVolvo.loadOn(volvo);
            //verkstadMedVolvo.loadOn(saab);
            assertEquals(1, verkstadMedVolvo.getCapacity());

            // Kollar om det fungerar att lägga till olika typer.
            verkstadMedAllaTrucks.loadOn(scania);
            verkstadMedAllaTrucks.loadOn(bilTransport);
            //verkstadMedAllaTrucks.loadOn(volvo);
            assertEquals(2, verkstadMedAllaTrucks.getCapacity());
        }

        @Test
        public void unLoadCar() {
            verkstadMedVolvo.loadOn(volvo);
            verkstadMedAllaTrucks.loadOn(scania);

            // Kollar om det går med en Volvo-verkstad
            verkstadMedVolvo.unLoadCar(volvo);
            //verkstadMedVolvo.unLoadCar(saab);
            assertEquals(0, verkstadMedVolvo.getCapacity());

            // Kollar om det går för en verkstad med alla typer av lastbilar.
            verkstadMedAllaTrucks.unLoadCar(scania);
            assertEquals(0, verkstadMedAllaTrucks.getCapacity());
        }

    @Test
    public void loadCar() {
        bilTransport.lowerRamp();
        bilTransport.loadCar(volvo);
        bilTransport.loadCar(saab);
        assertEquals(2, bilTransport.getFlak().size());

        //more than MAX_LOAD
        bilTransport.loadCar(volvo);
        bilTransport.loadCar(volvo);
        bilTransport.loadCar(saab);
        try {
            bilTransport.loadCar(volvo);
        } catch (IllegalArgumentException e) {
            System.out.println("reached full capacity");
        }
    }

    @Test
    public void onRamp() { // För att kontrollera att volvo är lastad på bilTransporten.
       bilTransport.loadCar(volvo);
       assertEquals(bilTransport.getPosition(), volvo.getPosition());
       scania.move();
    }

    @Test
    public void unloadCar(){
        bilTransport.lowerRamp();
        bilTransport.loadCar(volvo);
        bilTransport.loadCar(saab);
        bilTransport.unLoadCar();
        assertEquals(2, bilTransport.getFlak().size());
        assertEquals(saab.toString(), bilTransport.getFlak().getFirst().toString());
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
    public void updateBilTransport() {
        // Testar BilTransportens koordinater vs bilens/bilarnas.
        bilTransport.getRamp().setRampState(false);
        bilTransport.loadCar(volvo);
        bilTransport.getRamp().setRampState(true);

        // Testar om bilarna har samma position.
        bilTransport.setCurrentSpeed(20);
        bilTransport.move();
        assertEquals(volvo.getPosition(), bilTransport.getPosition());
    }
}