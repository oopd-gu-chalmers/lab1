import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCars {
    private Cars set;
    @Before
    public void init() {
        set = new ARSet();
        set.add(7);
        set.add(7);
    }

    @Test
    public void testAddcheckifAdded() {
        ARSet set = new ARSet();
        int size = set.size();

        set.add(5);
        assertTrue(size < set.size());
    }
    @Test
    public void testAddTwoIdenticalElementinset() {
        assertEquals(1, set.size());
    }

    @Test
    public void testAddTwoIdenticalElementinsetContainsAddedNum() {
        assertTrue(set.contains(7));
    }
}
}
