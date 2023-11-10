import java.awt.*;
import java.util.Arrays;

public class Main {
    public Main(){

    }

    public static void getInfo(Car car){
        System.out.println("Col: " + car.getColor());
        System.out.println("Doors: " + car.getNrDoors());
        System.out.println("Pow: " + car.getEnginePower());
        System.out.println("Speed: " + car.getCurrentSpeed());

        System.out.println("Rot: " + car.getRotation());
        System.out.println("Pos: " + Arrays.toString(car.getPosition()));

        System.out.println();
    }

    public static void main(String[] args){
        Volvo240 volvo = new Volvo240();
        getInfo(volvo);
        volvo.startEngine();
        volvo.gas(0.3);
        volvo.move();
        getInfo(volvo);
        volvo.turnRight(90);
        volvo.move();
        volvo.turnRight(12);
        volvo.gas(0.6);
        volvo.move();
        volvo.setColor(Color.red);
        getInfo(volvo);
    }
}
