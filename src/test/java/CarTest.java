import java.awt.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car = new Car(Color.ORANGE, 5, 100, "TestCar");
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

    @ParameterizedTest
    @ValueSource(doubles = {-1e-10, -0.5, -1, -50})
    void gasWithAmountBelowZeroShouldThrowIllegalArgumentException(double amount) {
        assertThrows(IllegalArgumentException.class, () -> {
            car.gas(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(doubles = {1+1e-10, 1.5, 2, 50})
    void gasWithAmountAboveOneShouldThrowIllegalArgumentException(double amount) {
        assertThrows(IllegalArgumentException.class, () -> {
            car.gas(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1e-10, -0.5, -1, -50})
    void brakeWithAmountBelowZeroShouldThrowIllegalArgumentException(double amount) {
        assertThrows(IllegalArgumentException.class, () -> {
            car.brake(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(doubles = {1+1e-10, 1.5, 2, 50})
    void brakeWithAmountAboveOneShouldThrowIllegalArgumentException(double amount) {
        assertThrows(IllegalArgumentException.class, () -> {
            car.brake(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.5, 1})
    void gasMustNotDecreaseCurrentSpeed(double amount) {
        double initialSpeed = car.getCurrentSpeed();
        car.gas(amount);
        assertFalse(initialSpeed > car.getCurrentSpeed());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.5, 1})
    void brakeMustNotIncreaseCurrentSpeed(double amount) {
        double initialSpeed = car.getCurrentSpeed();
        car.brake(amount);
        assertFalse(initialSpeed < car.getCurrentSpeed());
    }

    @Test
    void currentSpeedCanNotBeOverEnginePower() {
        for (int i = 0; i < 10000; i++) {
            car.gas(1);
        }
        assertTrue(car.getCurrentSpeed() <= car.getEnginePower());
    }
    @Test
    void currentSpeedCanNotBeBelowZero() {
        for (int i = 0; i < 10000; i++) {
            car.brake(1);
        }
        assertTrue(car.getCurrentSpeed() >= 0);
    }
}