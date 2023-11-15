import java.awt.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car = new Car();
    @Test
    void settingColorToBlue() {
        car.setColor(Color.BLUE);
        assertEquals(Color.BLUE, car.getColor());
    }

    @Test
    void engineShouldBeRunningAfterStartingIt() {
        car.startEngine();
        assertTrue(car.engineIsRunning());
    }

    @Test
    void engineShouldNotBeRunningAfterStoppingIt() {
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
        double initialSpeed = car.getCurrentSpeed();
        car.brake(1);
        assertFalse(initialSpeed < car.getCurrentSpeed());
    }
}