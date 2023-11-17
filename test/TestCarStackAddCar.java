import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCarStackAddCar {
    private CarStack cars;
    private Volvo240 volvo;
    private Saab95 saab1;
    private Saab95 saab2;
    private Saab95 saab3;
    private MercedesCarTransport transport;

    @Before
    public void init() {
        cars = new CarStack(2, 2);
        volvo = new Volvo240();
        saab1 = new Saab95();
        saab2 = new Saab95();
        saab3 = new Saab95();
    }

    @Test
    public void testLoadedCarsIncreaseWhenAddingCar() {
        int oldNr = cars.getNrOfLoadedCars();
        cars.addCar(saab1);
        assertTrue(oldNr < cars.getNrOfLoadedCars());
    }

    @Test
    public void testAddCar() {
        cars.addCar(saab1);
        assertEquals(1, cars.getNrOfLoadedCars());
    }

    @Test
    public void testAddSameCarTwice() {
        cars.addCar(saab1);
        cars.addCar(saab1);
        assertEquals(1, cars.getNrOfLoadedCars());
    }

    @Test
    public void testAddTooManyCars() {
        cars.addCar(saab1);
        cars.addCar(saab2);
        cars.addCar(saab3);
        assertEquals(2, cars.getNrOfLoadedCars());
    }

    @Test
    public void testAddTooBigCar() {
        cars.addCar(volvo);
        assertEquals(0, cars.getNrOfLoadedCars());
    }

    @Test
    public void testAddNonLoadableCar() {
        transport = new MercedesCarTransport(0, 0);
        cars.addCar(transport);
        assertEquals(0, cars.getNrOfLoadedCars());
    }
}