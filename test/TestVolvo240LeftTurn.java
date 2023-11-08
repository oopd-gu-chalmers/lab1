import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVolvo240LeftTurn {
    private Volvo240 volvo;
    private final double[] start = {0, 1};
    private final double[] newDirection = {-1, 0};

    @Before
    public void init() {
        volvo = new Volvo240();
    }

    @Test
    public void checkInitialXDirection() {
        assertEquals(start[0], volvo.getDirection()[0], 0.01);
    }

    @Test
    public void checkInitialYDirection() {
        assertEquals(start[1], volvo.getDirection()[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterOneLeftTurn() {
        volvo.turnLeft();
        assertEquals(newDirection[0], volvo.getDirection()[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterOneLeftTurn() {
        volvo.turnLeft();
        assertEquals(newDirection[1], volvo.getDirection()[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterFullCounterClockwiseRotation() {
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        assertEquals(start[0], volvo.getDirection()[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterFullCounterClockwiseRotation() {
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        assertEquals(start[1], volvo.getDirection()[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterFullCounterClockwiseRotationPlusOneTurn() {
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        assertEquals(newDirection[0], volvo.getDirection()[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterFullCounterClockwiseRotationPlusOneTurn() {
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        assertEquals(newDirection[1], volvo.getDirection()[1], 0.01);
    }
}
