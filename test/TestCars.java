import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;


public class TestCars {

    Saab95 mySaab95;
    Volvo240 myVolvo240;

    Scania myScania;
    @Before
    public void setup() {
        mySaab95 = new Saab95();
        myVolvo240 = new Volvo240();
        myScania = new Scania();
    }



    @Test
    public void test_if_startEngine_sets_current_speed(){
        myVolvo240.startEngine();
        assertEquals(0.1, myVolvo240.getCurrentSpeed(), 0.0);
        mySaab95.startEngine();
        assertEquals(0.1, mySaab95.getCurrentSpeed(), 0.0);
    }
    @Test
    public void test_gas_and_break() {

        mySaab95.gas(1);
        mySaab95.gas(1);
        assertEquals(2.5D, mySaab95.getCurrentSpeed(), 0.0D);


        myVolvo240.gas(1);
        myVolvo240.gas(1);
        myVolvo240.gas(1);
        assertEquals(3.75D, myVolvo240.getCurrentSpeed(), 0.0D);

        mySaab95.brake(1);
        mySaab95.brake(1);
        assertEquals(0.0D,mySaab95.getCurrentSpeed(),0.0D);

        myVolvo240.brake(1);
        myVolvo240.brake(1);
        myVolvo240.brake(1);
        assertEquals(0.0D,mySaab95.getCurrentSpeed(),0.0D);
    }

    @Test
    public void test_if_direction_is_changed_myCar_changes_direction(){
        mySaab95.turnLeft();
        assertEquals("WEST", mySaab95.getDirection());
        mySaab95.turnLeft();
        assertEquals("SOUTH", mySaab95.getDirection());
        mySaab95.turnLeft();
        assertEquals("EAST", mySaab95.getDirection());
        mySaab95.turnLeft();
        assertEquals("NORTH", mySaab95.getDirection());
        mySaab95.turnRight();
        assertEquals("EAST", mySaab95.getDirection());
    }

    @Test
    public void test_if_move_Cars_changes_location(){
        mySaab95.startEngine();
        mySaab95.gas(1);


        mySaab95.move();
        assertEquals(0.0D, (mySaab95.getPositionX()), 0.0D);
        assertEquals(1.35D,(mySaab95.getPositionY()), 0.0D);

        mySaab95.turnRight();
        mySaab95.move();
        assertEquals(1.35D, (mySaab95.getPositionX()), 0.0D);
        assertEquals(1.35D,(mySaab95.getPositionY()), 0.0D);

        mySaab95.turnRight();
        mySaab95.move();
        assertEquals(1.35D, (mySaab95.getPositionX()), 0.0D);
        assertEquals(0.0D,(mySaab95.getPositionY()), 0.0D);

        mySaab95.turnRight();
        mySaab95.move();
        assertEquals(0.0D, (mySaab95.getPositionX()), 0.0D);
        assertEquals(0.0D,(mySaab95.getPositionY()), 0.0D);
        mySaab95.turnRight();

    }
    @Test
    public void test_if_car_has_color_doors_and_modelName(){
        assertEquals("Volvo240", myVolvo240.getModelName());
        assertEquals("Saab95", mySaab95.getModelName());
        assertEquals(Color.BLACK, myVolvo240.getColor());
        assertEquals(Color.RED, mySaab95.getColor());
        assertEquals(4, myVolvo240.getNrDoors());
        assertEquals(2, mySaab95.getNrDoors());

    }

    @Test
    public void test_if_saab95_has_turbo(){
        mySaab95.startEngine();
        mySaab95.gas(1);
        assertEquals(1.35, mySaab95.getCurrentSpeed(), 0.0);

        mySaab95.stopEngine();
        mySaab95.startEngine();
        mySaab95.setTurboOn();
        mySaab95.gas(1);
        assertEquals(1.725, mySaab95.getCurrentSpeed(), 0.0);
    }

    @Test
    public void test_if_volvo240_has_trimFactor(){
        myVolvo240.startEngine();
        myVolvo240.gas(1);
        assertEquals(1.35D, myVolvo240.getCurrentSpeed(), 0.0);
        myVolvo240.stopEngine();
    }

    @Test
    public void test_if_bedAngle_can_extend_limit_of_vehicle(){
        myScania.truckBed.lowerBedAngle(10);
        assertEquals(0,myScania.truckBed.getBedAngle(),0.0);
        myScania.truckBed.raiseBedAngle(90);
        assertEquals(70, myScania.truckBed.getBedAngle(), 0.0);

    }
    @Test
    public void test_if_you_can_drive_truck_when_bed_is_raised(){
        myScania.truckBed.raiseBedAngle(10);
        myScania.startEngine();
        assertEquals(0, myScania.getCurrentSpeed(), 0.0);

        myScania.truckBed.lowerBedAngle(10);
        myScania.startEngine();
        myScania.truckBed.raiseBedAngle(10);
        //assertEquals(0, myScania.truckBed.getBedAngle(), 0.0); TODO raisebedangle tittar inte om currentspeed inte är 0

        myScania.stopEngine();
        myScania.truckBed.raiseBedAngle(10);
        myScania.gas(1);
        assertEquals(0, myScania.getCurrentSpeed(), 0.0);
    }

}
