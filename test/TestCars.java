import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestCars {

    Saab95 mySaab95;
    Volvo240 myVolvo240;

    @Before
    public void setup() {
        mySaab95 = new Saab95();
        myVolvo240 = new Volvo240();
    }
    @Test
    public void test_if_cars_object_exist_when_created(){
        assertTrue(myVolvo240.equals(myVolvo240));
        assertTrue(mySaab95.equals(mySaab95));
    }

    @Test
    public void test_if_startEngine_sets_current_speed(){
        myVolvo240.startEngine();
        assertTrue(myVolvo240.getCurrentSpeed() == 0.1);
        mySaab95.startEngine();
        assertTrue(mySaab95.getCurrentSpeed() == 0.1);
    }

    @Test
    public void test_if_direction_is_changed_myCar_changes_direction(){
        mySaab95.turnLeft();
        assertEquals("WEST", mySaab95.direction.name());
        mySaab95.turnLeft();
        assertEquals("SOUTH", mySaab95.direction.name());
        mySaab95.turnLeft();
        assertEquals("EAST", mySaab95.direction.name());
        mySaab95.turnLeft();
        assertEquals("NORTH", mySaab95.direction.name());
        mySaab95.turnRight();
        assertEquals("EAST", mySaab95.direction.name());
    }

    @Test
    public void test_if_setCurrentSpeed(){
        mySaab95.setCurrentSpeed(40);
        assertEquals(40, mySaab95.getCurrentSpeed(), 0.0F);
        myVolvo240.setCurrentSpeed(40);
        assertEquals(40,myVolvo240.getCurrentSpeed(),0.0F);
    }

    @Test
    public void test_if_incrementSpeed_changes_currentSpeed(){
        mySaab95.incrementSpeed(40);
        assertEquals(50.0F,(mySaab95.getCurrentSpeed()), 0.0F);

        myVolvo240.incrementSpeed(40);
        assertEquals(50.0F,(myVolvo240.getCurrentSpeed()), 0.0F);

        myVolvo240.incrementSpeed(356);
        assertEquals(100.0F,(myVolvo240.getCurrentSpeed()), 0.0F);
    }

    @Test
    public void test_if_decrementSpeed_changes_currentSpeed(){
        mySaab95.setCurrentSpeed(50);
        mySaab95.decrementSpeed(40);
        assertEquals(0.0F,(mySaab95.getCurrentSpeed()), 0.0F);

        myVolvo240.setCurrentSpeed(50);
        myVolvo240.decrementSpeed(40);
        assertEquals(0.0F,(mySaab95.getCurrentSpeed()), 0.0F);

        myVolvo240.setCurrentSpeed(100);
        myVolvo240.decrementSpeed(7642);
        assertEquals(0.0F,(mySaab95.getCurrentSpeed()), 0.0F);
    }

    @Test
    public void test_if_move_Cars_changes_location(){
        mySaab95.gas(15);

        mySaab95.direction = Cars.Direction.NORTH;
        mySaab95.move();
        assertEquals(0.0F, (mySaab95.getPositionX()), 0.0F);
        assertEquals(18.75F,(mySaab95.getPositionY()), 0.0F);

        mySaab95.direction = Cars.Direction.EAST;
        mySaab95.move();
        assertEquals(18.75F, (mySaab95.getPositionX()), 0.0F);
        assertEquals(18.75F,(mySaab95.getPositionY()), 0.0F);

        mySaab95.direction = Cars.Direction.SOUTH;
        mySaab95.move();
        assertEquals(18.75F, (mySaab95.getPositionX()), 0.0F);
        assertEquals(0.0F,(mySaab95.getPositionY()), 0.0F);

        mySaab95.direction = Cars.Direction.WEST;
        mySaab95.move();
        assertEquals(0.0F, (mySaab95.getPositionX()), 0.0F);
        assertEquals(0.0F,(mySaab95.getPositionY()), 0.0F);
    }
    @Test
    public void test_if_car_has_color_doors_and_modelName(){
        myVolvo240.setColor(Color.BLACK);
        mySaab95.setColor(Color.RED);
        assertEquals("Volvo240", myVolvo240.getmodelName());
        assertEquals("Saab95", mySaab95.getmodelName());
        assertEquals(Color.BLACK, myVolvo240.getColor());
        assertEquals(Color.RED, mySaab95.getColor());
        assertEquals(4, myVolvo240.getNrDoors());
        assertEquals(2, mySaab95.getNrDoors());

    }

    @Test
    public void test_if_saab95_has_turbo(){
        mySaab95.startEngine();
        mySaab95.gas(5);
        assertTrue(mySaab95.getCurrentSpeed() == 6.35);

        mySaab95.stopEngine();
        mySaab95.startEngine();
        mySaab95.setTurboOn();
        mySaab95.gas(5);
        assertTrue(mySaab95.getCurrentSpeed() == 8.225);
    }

    @Test
    public void test_if_volvo240_has_trimfactor(){
        myVolvo240.startEngine();
        myVolvo240.gas(5);
        assertTrue(myVolvo240.getCurrentSpeed() == 6.35);

        myVolvo240.decrementSpeed(5);
        assertTrue(myVolvo240.getCurrentSpeed() == 0.1);
    }
}
