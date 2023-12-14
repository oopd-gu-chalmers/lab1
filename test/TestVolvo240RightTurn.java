import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVolvo240RightTurn {
    private Volvo240 Volvo;
    private final double[] start = {0, 1};
    private final double[] newDirection = {1, 0};

    @Before
    public void init() {
        Volvo = new Volvo240();
    }

    @Test
    public void checkInitialXDirection() {
        assertEquals(start[0], Volvo.getDirection()[0], 0.01);
    }

    @Test
    public void checkInitialYDirection() {
        assertEquals(start[1], Volvo.getDirection()[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterOneRightTurn() {
        Volvo.turnRight();
        assertEquals(newDirection[0], Volvo.getDirection()[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterOneRightTurn() {
        Volvo.turnRight();
        assertEquals(newDirection[1], Volvo.getDirection()[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterFullClockwiseRotation() {
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        assertEquals(start[0], Volvo.getDirection()[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterFullClockwiseRotation() {
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        assertEquals(start[1], Volvo.getDirection()[1], 0.01);
    }

    @Test
    public void checkXDirectionAfterFullClockwiseRotationPlusOneTurn() {
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        assertEquals(newDirection[0], Volvo.getDirection()[0], 0.01);
    }

    @Test
    public void checkYDirectionAfterFullClockwiseRotationPlusOneTurn() {
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        assertEquals(newDirection[1], Volvo.getDirection()[1], 0.01);
    }
}