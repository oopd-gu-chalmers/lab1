import java.awt.*;
public class Main {
    public Main(){

    }

    public static void main(String[] args){
        Volvo240 volvo = new Volvo240();
        volvo.incrementSpeed(10);
        System.out.println(volvo.getCurrentSpeed());
        System.out.println(volvo.getPosition()[0] + "," + volvo.getPosition()[1]);
        System.out.println(volvo.getDirection());
        volvo.move();
        System.out.println(volvo.getPosition()[0] + "," + volvo.getPosition()[1]);
        System.out.println(volvo.getDirection());
        volvo.turnLeft();
        System.out.println(volvo.getPosition()[0] + "," + volvo.getPosition()[1]);
        System.out.println(volvo.getDirection());
    }
}
