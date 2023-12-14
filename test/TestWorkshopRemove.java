import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class TestWorkshopRemove {
    private final Volvo240 p = new Volvo240();
    private final Volvo240 r = new Volvo240();
    private final Saab95 q = new Saab95();

    private Workshop<Volvo240> workshop;

    @Before
    public void init() {
        workshop = new Workshop<>(2);
        workshop.addCar(r);
        workshop.addCar(p);
    }

    @Test
    public void testIfYouCanRemove() {
        workshop.removeCar(p);
        assertEquals(1,workshop.cars.size(),0.01);
    }
}
