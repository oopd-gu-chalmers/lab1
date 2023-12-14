import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSaab95RightTurn {
    private Saab95 saab;
    private final double[] start = {0, 1};
    private final double[] newDirection = {1, 0};

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
    public void testXDirectionAfterOneRightTurn() {
        saab.turnRight();
        assertEquals(newDirection[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void testYDirectionAfterOneRightTurn() {
        saab.turnRight();
        assertEquals(newDirection[1], saab.getDirection()[1], 0.01);
    }

    @Test
    public void testXDirectionAfterFullClockwiseRotation() {
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals(start[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void testYDirectionAfterFullClockwiseRotation() {
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals(start[1], saab.getDirection()[1], 0.01);
    }

    @Test
    public void testXDirectionAfterFullClockwiseRotationPlusOneTurn() {
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals(newDirection[0], saab.getDirection()[0], 0.01);
    }

    @Test
    public void testYDirectionAfterFullClockwiseRotationPlusOneTurn() {
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals(newDirection[1], saab.getDirection()[1], 0.01);
    }
}