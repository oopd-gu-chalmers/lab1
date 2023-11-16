import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class TestWorkshopAdd {
    private final Workshop workshop = new Workshop("Volvo240",1);

    private final Car p = new Volvo240();
    private final Car r = new Volvo240();
    private final Car q = new Saab95();

    @Test
    public void testIfEmptyWhenInitialized(){
        assertTrue(workshop.cars.isEmpty());
    }
    @Test
    public void testIfCanAddWhenNotFull(){
        workshop.addCar(p);
        assertEquals(1, workshop.cars.size(),0.01);
    }
    @Test
    public void testIfCannotAddWhenFull() {
        workshop.addCar(p);
        workshop.addCar(r);
        assertEquals(1, workshop.cars.size(),0.01);
    }
    @Test
    public void testIfCannotAddWrongBrand() {
        workshop.addCar(p);
        workshop.addCar(q);
        assertEquals(1, workshop.cars.size(),0.01);
    }
}
