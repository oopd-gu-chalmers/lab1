import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSaab95LeftTurn {
    private Saab95 saab;
    private final double[] start = {0, 1};
    private final double[] newDirection = {-1, 0};

    @Before
    public void init() {
        saab = new Saab95();
        saab.turnLeft();
    }

    @Test
    public void checkInitialDirection() {
        assertEquals(saab.getPosition(), start);
    }

    @Test
    public void checkOneLeftTurn() {
        assertEquals(saab.getDirection(), newDirection);
    }

    @Test
    public void checkFullCounterClockwiseRotation() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(saab.getDirection(), start);
    }

    @Test
    public void checkFullCounterClockwiseRotationPlusOneTurn() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(saab.getDirection(), newDirection);
    }
}
