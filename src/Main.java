import java.awt.*;
public class Main {
    public Main(){

    }

    public static void main(String[] args){
        Volvo240 volvo = new Volvo240();
        volvo.getInfo();
        volvo.startEngine();
        volvo.gas(0.3);
        volvo.move();
        volvo.getInfo();
        volvo.turnRight();
        volvo.move();
        volvo.turnRight();
        volvo.gas(0.6);
        volvo.move();
        volvo.setColor(Color.red);
        volvo.getInfo();
    }
}
