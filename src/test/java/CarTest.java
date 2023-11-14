import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car = new Car();
    @org.junit.jupiter.api.Test
    void setColor() {
        car.setColor(Color.BLUE);
        assertEquals(Color.BLUE, car.getColor());
    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        car.startEngine();
        assertTrue(car.engineIsRunning());
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        car.stopEngine();
        assertFalse(car.engineIsRunning());
    }

    @org.junit.jupiter.api.Test
    void gas() {
    }

    @org.junit.jupiter.api.Test
    void brake() {
    }
}