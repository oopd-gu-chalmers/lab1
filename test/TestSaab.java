import elements.vehicles.passengerCars.Saab95;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
public class TestSaab {
    Saab95 saab;

    @Before
    public void before(){
        saab = new Saab95();
    }

    @Test
    public void turboOnShouldMoveFaster(){
        saab.startEngine();
        saab.gas(0.5);
        double normalSpeed = saab.getSpeed();

        saab.stopEngine();

        saab.startEngine();
        saab.setTurboOn();
        saab.gas(0.5);

        assertTrue(saab.getSpeed() > normalSpeed);
    }

}
