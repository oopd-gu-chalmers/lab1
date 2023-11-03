import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestCar {
    private List<Car> testCars;

    @Before
    public void setup() {
        testCars.add(new Saab95());
        testCars.add(new Volvo240());
    }
}
