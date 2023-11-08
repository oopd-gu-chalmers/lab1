import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testMove {
    private Saab95 saab;
    private Volvo240 volvo;

    @Before
    public void init() {
        saab = new Saab95();
        volvo = new Volvo240();
    }

    @Test
    public void checkSaabStartPosition() {
        double[] start = {0, 0};
        assertEquals(start, saab.getPosition());
    }

    @Test
    public void checkVolvoStartPosition() {
        double[] start = {0, 0};
        assertEquals(start, volvo.getPosition());
    }
}
