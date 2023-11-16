import assets.elements.vehicles.Car;
import assets.elements.vehicles.cars.passengerCars.Volvo240;

import java.awt.*;
import java.util.Arrays;

public class DebugGetInfo {

    public static void getInfo(Car car){
        System.out.println("Col: " + car.getColor());
        System.out.println("Doors: " + car.getNrDoors());
        System.out.println("Pow: " + car.getEngine().getMaxEnginePower());
        System.out.println("Speed: " + car.getSpeed());

        System.out.println("Rot: " + car.getRotation());
        System.out.println("Pos: " + Arrays.toString(car.getPosition()));

        System.out.println();
    }

    public static void main(String[] args){
        Volvo240 volvo = new Volvo240();
        getInfo(volvo);
        volvo.start();
        volvo.gas(0.3);
        volvo.moveTick();
        getInfo(volvo);
        volvo.turnRight(90);
        volvo.moveTick();
        volvo.turnRight(12);
        volvo.gas(0.6);
        volvo.moveTick();
        volvo.setColor(Color.red);
        getInfo(volvo);
    }
}
