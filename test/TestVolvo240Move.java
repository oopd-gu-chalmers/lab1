import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVolvo240Move {
    private Volvo240 volvo;

    private final double[] start = {0, 0};

    @Before
    public void init() {
        volvo = new Volvo240();
        volvo.startEngine();
    }

    @Test
    public void checkStartXPosition() {
        assertEquals(start[0], volvo.getPosition()[0], 0.01);
    }

    @Test
    public void checkStartYPosition() {
        assertEquals(start[1], volvo.getPosition()[1], 0.01);
    }

    @Test
    public void checkXPositionAfterOneMove() {
        volvo.move();
        assertEquals(0, volvo.getPosition()[0], 0.01);
    }

    @Test
    public void checkYPositionAfterOneMove() {
        volvo.move();
        assertEquals(volvo.getCurrentSpeed(), volvo.getPosition()[1], 0.01);
    }
}

