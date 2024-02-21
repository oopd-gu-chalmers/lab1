import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    static Garage<Volvo240> garage = new Garage(10, new Point(300, 0));
    static vehicleFactory factory = new vehicleFactory();
    private static Timer timer;


    public static void main(String[] args) {
        factory.buildSaab95();
        factory.buildVolvo240();
        factory.buildScania();
        timer.start();

    }

    public void update() {
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle car : factory.getVehicles()) {
                    car.move();
                }
            }
    }
}
