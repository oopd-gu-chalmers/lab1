import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garageGeneral;
    Garage garageSaab95;
    Volvo240 volvo240;
    Saab95 saab95;


    @BeforeEach
    void setUp() {
        garageGeneral = new Garage(2);
        garageSaab95 = new Garage<Saab95>(2);
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
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
        assertArrayEquals();
    }
}