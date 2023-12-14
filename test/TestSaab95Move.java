import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSaab95Move {
    private Saab95 saab;

    private final double[] start = {0, 0};

    @Before
    public void init() {
        saab = new Saab95();
        saab.startEngine();
    }

    @Test
    public void testStartXPosition() {
        assertEquals(start[0], saab.getPosition()[0], 0.01);
    }

    @Test
    public void testStartYPosition() {
        assertEquals(start[1], saab.getPosition()[1], 0.01);
    }

    @Test
    public void testXPositionAfterOneMove() {
        saab.move();
        assertEquals(0, saab.getPosition()[0], 0.01);
    }

    @Test
    public void testYPositionAfterOneMove() {
        saab.move();
        assertEquals(saab.getCurrentSpeed(), saab.getPosition()[1], 0.01);
    }
}