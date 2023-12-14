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
    public void testInitialXDirection() {
        assertEquals(start[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void testInitialYDirection() {
        assertEquals(start[1], saab.getDirection()[1], 0.01);
    }

    @Test
    public void testXDirectionAfterOneLeftTurn() {
        saab.turnLeft();
        assertEquals(newDirection[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void testYDirectionAfterOneLeftTurn() {
        saab.turnLeft();
        assertEquals(newDirection[1], saab.getDirection()[1], 0.01);
    }

    @Test
    public void testXDirectionAfterFullCounterClockwiseRotation() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(start[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void testYDirectionAfterFullCounterClockwiseRotation() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(start[1], saab.getDirection()[1], 0.01);
    }

    @Test
    public void testXDirectionAfterFullCounterClockwiseRotationPlusOneTurn() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(newDirection[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void testYDirectionAfterFullCounterClockwiseRotationPlusOneTurn() {
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(newDirection[1], saab.getDirection()[1], 0.01);
    }
}
