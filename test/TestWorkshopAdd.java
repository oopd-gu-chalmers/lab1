import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestWorkshopAdd {
    //private Workshop<Volvo240> workshop;
    private final Volvo240 p = new Volvo240();
    private final Volvo240 r = new Volvo240();
    private final Saab95 q = new Saab95();



    @Test
    public void testIfEmptyWhenInitialized(){
        Workshop<Volvo240> workshop = new Workshop<>("Volvo240",1);
        assertTrue(workshop.cars.isEmpty());
    }
    @Test
    public void testIfCanAddWhenNotFull(){
        Workshop<Volvo240> workshop = new Workshop<>("Volvo240",1);
        workshop.addCar(p);
        assertEquals(1, workshop.cars.size(),0.01);
    }
    @Test
    public void testIfCannotAddWhenFull() {
        Workshop<Volvo240> workshop = new Workshop<>("Volvo240",1);
        workshop.addCar(p);
        workshop.addCar(r);
        assertEquals(1, workshop.cars.size(),0.01);
    }
    @Test //Ska ta bort detta test maybe, är detta compile time error?
    public void testIfCannotAddWrongBrand() {
        Workshop<Volvo240> workshop = new Workshop<>("Volvo240",2);
        workshop.addCar(p);
        //workshop.addCar(q);
        assertEquals(1, workshop.cars.size(),0.01);
    }
    @Test
    public void testIfCanAddAnyCarWhenNoBrand(){
        Workshop<Car> workshop = new Workshop<>(2);
        workshop.addCar(p);
        workshop.addCar(q);
        assertEquals(2, workshop.cars.size(),0.01);
    }
}
