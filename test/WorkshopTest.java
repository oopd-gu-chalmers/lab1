import assets.elements.Workshop;
import assets.elements.vehicles.cars.trucks.ManTGX;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorkshopTest {

    Workshop<ManTGX> workshop;
    @Before
    public void setUp() {
        workshop = new Workshop<>(3);
    }

    @Test
    public void testSubmit() {
        workshop.submit(new ManTGX());
        workshop.submit(new ManTGX());
        assertEquals(2, workshop.getCurrentVehicleCount());
    }

    @Test
    public void testRetrieve() {
        ManTGX yoman = new ManTGX();
        workshop.submit(yoman);
        workshop.retrieve(yoman);
        assertEquals(0, workshop.getCurrentVehicleCount());
    }

    @Test
    public void testRetrieveFail() {
        ManTGX yoman = new ManTGX();
        workshop.retrieve(yoman);
        assertEquals(0, workshop.getCurrentVehicleCount());
    }

    @Test
    public void testGetMaxVehicleCount() {
        for (int i = 0; i < workshop.getMaxVehicleCount() + 2; i++){
            workshop.submit(new ManTGX());
        }
        assertEquals(workshop.getMaxVehicleCount(), workshop.getCurrentVehicleCount());
    }
}