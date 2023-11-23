import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VolvoVAH300Test {
    private final VolvoVAH300 volvoVAH300 = new VolvoVAH300();
    private final ArrayList<ICar> cars = new ArrayList<>(Arrays.asList(
            new Volvo240(),
            new Volvo240(),
            new Volvo240(),
            new Saab95()
    ));

    @Test
    void getNrOfAvailableSlots() {
        volvoVAH300.openPlatform();
        for (ICar car : cars) {
            volvoVAH300.load(car);
        }
        assertEquals(Math.max(0, volvoVAH300.getMaxNrOfItems() - cars.size()), volvoVAH300.getNrOfAvailableSlots());
    }

    @Test
    void getLoadedItemsShouldReturnListOfAllLoadedCars() {
        volvoVAH300.openPlatform();
        for (ICar car : cars) {
            volvoVAH300.load(car);
        }
        assertEquals(volvoVAH300.getLoadedItems(), cars);
    }

    @Test
    void loadWhenCarIsTooFarAwayShouldReturnFalse() {
        Volvo240 volvo240 = new Volvo240();
        do {
            volvo240.gas(1);
            volvo240.move();
        } while (volvo240.getPosition().distance(volvoVAH300.getPosition()) < 20);
        volvoVAH300.openPlatform();
        assertFalse(volvoVAH300.load(volvo240));
    }

    @Test
    void loadWhenPlatformIsNotFullyOpenedShouldReturnFalse() {
        Volvo240 volvo240 = new Volvo240();
        volvoVAH300.closePlatform();
        assertFalse(volvoVAH300.load(volvo240));
    }
    
    @Test
    void shouldNotBeAbleToLoadMoreThanMaxNrOfItems() {
        volvoVAH300.openPlatform();
        for (int i = 0; i < volvoVAH300.getMaxNrOfItems(); i++) {
            volvoVAH300.load(new Volvo240());
        }
        assertFalse(volvoVAH300.load(new Volvo240()));
    }

    @Test
    void shouldNotBeAbleToLoadCarsThatAreTooBig() {
        Car car = new Car(Color.BLACK, 130, "TestCar", 4, UnitSize.LARGE_CAR_UNIT_SIZE);
        volvoVAH300.openPlatform();
        assertFalse(volvoVAH300.load(car));
    }

    @Test
    void platformCanNotBeOpenedWhenCurrentSpeedIsNotZero() {
        do {
            volvoVAH300.gas(1);
        } while (volvoVAH300.getCurrentSpeed() == 0);
        volvoVAH300.openPlatform();
        assertTrue(volvoVAH300.platformIsFullyClosed());
    }

    @Test
    void currentSpeedMustBeZeroWhenPlatformIsOpen() {
        do {
            volvoVAH300.brake(1);
        } while (volvoVAH300.getCurrentSpeed() != 0);
        volvoVAH300.openPlatform();
        volvoVAH300.gas(1);
        assertEquals(0, volvoVAH300.getCurrentSpeed());
    }

    @Test
    void unloadingCarShouldPlaceItCloseToTruck() {
        Volvo240 volvo240 = new Volvo240();
        volvoVAH300.load(volvo240);
        volvoVAH300.unload();
        assertTrue(volvo240.getPosition().distance(volvoVAH300.getPosition()) < 20);
    }

    @Test
    void carPositionShouldBeTheSameAsTruckPositionWhenItIsLoaded() {
        Saab95 saab95 = new Saab95();
        volvoVAH300.openPlatform();
        volvoVAH300.load(saab95);
        assertSame(saab95.getPosition(), volvoVAH300.getPosition());
    }
}