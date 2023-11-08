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
    }

    @Test
    public void checkInitialXDirection() {
        assertEquals(start[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void checkInitialYDirection() {
        assertEquals(start[1], saab.getDirection()[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterOneLeftTurn() {
        saab.turnLeft();
        assertEquals(newDirection[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterOneLeftTurn() {
        saab.turnLeft();
        assertEquals(newDirection[1], saab.getDirection()[1], 0.01);
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
        assertEquals(newDirection[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterFullCounterClockwiseRotationPlusOneTurn() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(newDirection[1], saab.getDirection()[1], 0.01);
    }
}
