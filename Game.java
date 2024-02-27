import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Game {
    private static final int windowX = 800;
    private static final int windowY = 800;
    static Garage<Volvo240> garage = new Garage(10, new Point(300, 0));
    static vehicleFactory factory = new vehicleFactory();
    private static Timer timer;
    static CarController controller = new CarController(factory.getVehicles());
    static DrawObjects objects = new DrawObjects(windowX, windowY);
    static DrawPanel frame = new DrawPanel("CarSim 1.0", controller, windowX, windowY);


    public static void main(String[] args) {
        factory.buildSaab95();
        factory.buildVolvo240();
        factory.buildScania();
        update();
        frame.add(objects);
        frame.pack();
        timer.start();

    }

    public static void update() {
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<Vehicle> carIterator = factory.getVehicles().iterator();
                while (carIterator.hasNext()) {
                    Vehicle car = carIterator.next();
                    car.move();
                    int x = (int) Math.round(car.getXPosition());
                    int y = (int) Math.round(car.getYPosition());
                    objects.moveit(x, y, car);
                    if (car.getXPosition() > windowX - 100 || car.getXPosition() < 0 || car.getYPosition() >windowY - 100 || car.getYPosition() < 0) {
                        car.reverseDirection();
                    }
                    if (car instanceof Volvo240 && car.getPosition().equals(garage.getLocation())) {
                        garage.load((Volvo240) car);
                        carIterator.remove();
                    }
                    objects.repaint();
                }
            }
        });
    }
}
