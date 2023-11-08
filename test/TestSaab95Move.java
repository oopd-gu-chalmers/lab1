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
    public void checkStartPosition() {
        assertEquals(start, saab.getPosition());
    }

    @Test
    public void checkPositionAfterOneMove() {
        double[] newPosition = {0, saab.getCurrentSpeed()};
        saab.move();
        assertEquals(saab.getPosition(), newPosition);
    }
}