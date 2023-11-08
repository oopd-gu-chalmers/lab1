import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSaab95RightTurn {
    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95();
        saab.turnRight();
    }
    @Test
    public void checkRightTurn() {
        assertEquals(saab.getDirection()[0], 0);
    }
}
