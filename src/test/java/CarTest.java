import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car = new Car();
    @Test
    void setColor() {
        car.setColor(Color.BLUE);
        assertEquals(Color.BLUE, car.getColor());
    }

    @Test
    void startEngine() {
        car.startEngine();
        assertTrue(car.engineIsRunning());
    }

    @Test
    void stopEngine() {
        car.stopEngine();
        assertFalse(car.engineIsRunning());
    }

    @Test
    void gas() {
        double initialSpeed = car.getCurrentSpeed();
        car.gas(1);
        assertFalse(initialSpeed > car.getCurrentSpeed());
    }

    @Test
    void brake() {
    }
}