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
    public void checkInitialXDirection() {
        assertEquals(saab.getDirection()[0], start[0], 0.01);
    }

    @Test
    public void checkInitialYDirection() {
        assertEquals(saab.getDirection()[1], start[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterOneLeftTurn() {
        assertEquals(saab.getDirection()[0], newDirection[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterOneLeftTurn() {
        assertEquals(saab.getDirection()[1], newDirection[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterFullCounterClockwiseRotation() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(start[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterFullCounterClockwiseRotation() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(start[1], saab.getDirection()[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterFullCounterClockwiseRotationPlusOneTurn() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(saab.getDirection()[0], newDirection[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterFullCounterClockwiseRotationPlusOneTurn() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(saab.getDirection()[1], newDirection[1], 0.01);
    }
}
