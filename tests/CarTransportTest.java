import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {
    CarTransport carTransport;
    Volvo240 volvo1;
    Volvo240 volvo2;
    Volvo240 volvo3;
    Saab95 saab1;
    Saab95 saab2;
    Saab95 saab3;

    @BeforeEach
    void setUp() {
        carTransport = new CarTransport();
        volvo1 = new Volvo240();
        volvo2 = new Volvo240();
        volvo3 = new Volvo240();
        saab1 = new Saab95();
        saab2 = new Saab95();
        saab3 = new Saab95();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void startEngine() {
        carTransport.lowerPlatform();
        assertThrows(IllegalStateException.class, () -> carTransport.startEngine());
    }

    @Test
    void incrementSpeed() {
        carTransport.lowerPlatform();
        assertThrows(IllegalStateException.class, () -> carTransport.incrementSpeed(1));
    }

    @Test
    void raisePlatform() {
        carTransport.lowerPlatform();
        carTransport.raisePlatform();
        assertTrue(carTransport.getRampState());

        carTransport.startEngine();
        assertThrows(IllegalStateException.class, () -> carTransport.raisePlatform());
    }

    @Test
    void lowerPlatform() {
        carTransport.lowerPlatform();
        assertFalse(carTransport.getRampState());

        carTransport.startEngine();
        assertThrows(IllegalStateException.class, () -> carTransport.lowerPlatform());
    }

    @Test
    void loadCar() {
        carTransport.lowerPlatform();
        carTransport.loadCar(volvo1);
        carTransport.loadCar(volvo2);
        carTransport.loadCar(volvo3);
        carTransport.loadCar(saab1);
        carTransport.loadCar(saab2);
        assertThrows(IllegalStateException.class, () -> carTransport.loadCar(saab3));

    }

    @Test
    void checkLoadedCarPosition(){
        carTransport.loadCar(volvo1);
        assertEquals(volvo1.getPosition(), carTransport.getPosition());
    }

    @Test
    void unloadCar() {
    }

    @Test
    void isRampUp() {
    }

    @Test
    void validateRampOperation() {
    }
}