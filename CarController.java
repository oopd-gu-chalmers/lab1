import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private ArrayList<BufferedImage> images = new ArrayList<>();
    private ArrayList<Point> points = new ArrayList<>();
    private boolean imageRenderingLimiter = false;
    //private ArrayList<Tuple(BufferedImage, Point)> .... maybe

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        Scania scania = new Scania();

        cc.vehicles.add(volvo);
        cc.vehicles.add(saab);
        cc.vehicles.add(scania);

        volvo.setPosition(new Point(0,0));
        saab.setPosition(new Point(100, 0));
        scania.setPosition(new Point(200,0));

        // Start a new view and send a reference of self
        cc.frame = new CarView("SimulateDeezCars", cc);

        // Start the timer
        cc.timer.start();




    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle car = vehicles.get(i);
                car.move();

                double carX = car.getPosition().getX();
                double carY = car.getPosition().getY();
                int width = frame.drawPanel.getWidth();
                int height = frame.drawPanel.getHeight();

                if (carX + car.getImage().getWidth() > width || carX < 0) {
                    car.stopEngine();
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();

                }
                else if (carY + car.getImage().getHeight() > height || carY < 0) {
                    car.stopEngine();
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();
                }

                // repaint() calls the paintComponent method of the panel
                if (!imageRenderingLimiter) {
                    images.add(i, car.getImage());
                }

                points.add(i, car.getPosition());
            }
            imageRenderingLimiter = true;
            frame.drawPanel.prePaint(points, images);
            frame.drawPanel.repaint();

        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles
                ) {
            car.gas(gas);
        }
    }

    // Calls the gas method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles
        ) {
            car.brake(brake);
        }
    }

    void startAllCars() {
        for (Vehicle car : vehicles
        ) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (Vehicle car : vehicles
        ) {
            car.stopEngine();
        }
    }

//    void turboOn() {
//        for (Vehicle car : vehicles) {
//            if (car instanceof Saab95) {
//                ((Saab95) car).turboOn();
//            }
//        }
//    }
}
