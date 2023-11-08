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
    public void checkStartXPosition() {
        assertEquals(saab.getPosition()[0], start[0], 0.01);
    }

    @Test
    public void checkStartYPosition() {
        assertEquals(saab.getPosition()[1], start[1], 0.01);
    }

    @Test
    public void checkXPositionAfterOneMove() {
        saab.move();
        assertEquals(saab.getPosition()[0], 0, 0.01);
    }

    @Test
    public void checkYPositionAfterOneMove() {
        saab.move();
        assertEquals(saab.getPosition()[1], saab.getCurrentSpeed(), 0.01);
    }
}