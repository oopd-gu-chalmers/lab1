import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCarStackRemoveCar {
    private CarStack cars;
    private Saab95 saab;
    private Volvo240 volvo;

    @Before
    public void init() {
        cars = new CarStack(2, 4);
        saab = new Saab95();
        volvo = new Volvo240();

        cars.addCar(saab);
        cars.addCar(volvo);
    }

    @Test
    public void testRemoveCarDecreasesNrOfCars() {
        int oldNr = cars.getNrOfLoadedCars();
        cars.removeCar();
        assertTrue(oldNr > cars.getNrOfLoadedCars());
    }

    @Test
    public void testRemoveCarReturnsSameCar() {
        Car tempCar = cars.removeCar();
        assertEquals(volvo.getClass(), tempCar.getClass());
    }

    @Test
    public void testRemoveTooManyCars() {
        cars.removeCar();
        cars.removeCar();
        Car tempCar = cars.removeCar();
        assertEquals(null, tempCar);
    }
}
