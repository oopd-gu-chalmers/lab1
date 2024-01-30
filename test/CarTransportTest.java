import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class CarTransportTest {
    private CarTransport carTransport;
    private Volvo240 volvo240;
    private Saab95 saab95;

    @BeforeEach
    void setUp() {
        carTransport = new CarTransport();
        volvo240 = new Volvo240();
        saab95 =new Saab95();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void move() {
    }

    @Test
    void gas() {
    }

    @Test
    void incrementAngle() {
    }

    @Test
    void decrementAngle() {
    }

    @Test
    void raiseRamp() {
        // Kan vara värt att testa ramperna likt i Scania här med
    }

    @Test
    void lowerRamp() {
    }

    @Test
    void loadCar() {
        carTransport.lowerRamp();

        assertDoesNotThrow(() -> carTransport.loadCar(volvo240)); // Will throw an Exception if Ramp is not lowered
        assertEquals(1, carTransport.cars.size()); // One car has been loaded
        }

    @Test
    void unloadCar() {
        carTransport.loadCar(volvo240);
        assertDoesNotThrow(carTransport::unloadCar); // No Exception while unloading
        assertEquals(0, carTransport.cars.size()); // No car on transport
    }
    @Test
    void maxLoadTest(){
        carTransport.lowerRamp();
        for (int i = 0; i < CarTransport.maxLoad; i++) {
            carTransport.loadCar(saab95);
        }
        // Try loading one more car
        Volvo240 extraCar = new Volvo240();
        assertThrows(IllegalStateException.class, () -> carTransport.loadCar(extraCar));

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
}