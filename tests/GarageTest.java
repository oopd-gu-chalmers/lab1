import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage<Car> garageGeneral;
    Garage<Saab95> garageSaab95;
    Volvo240 volvo240;
    Saab95 saab95;


    @BeforeEach
    void setUp() {
        garageGeneral = new Garage<>(2, new Point(0,0));
        garageSaab95 = new Garage<>(2, new Point(0,0));
        volvo240 = new Volvo240();
        saab95 = new Saab95();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void load() {
        garageGeneral.load(volvo240);
        assertEquals(volvo240, garageGeneral.unload());
    }

    @Test
    void unload() {
        garageGeneral.load(volvo240);
        garageGeneral.unload();
        assertEquals(0, garageGeneral.getLoadedCars().size());
    }
}