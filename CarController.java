import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private ArrayList<BufferedImage> images = new ArrayList<>();
    private ArrayList<Point> points = new ArrayList<>();

    private boolean imageRenderingLimiter = false;
    private BufferedImage volvoworkshopImage;




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
        saab.setPosition(new Point(0, 100));
        scania.setPosition(new Point(0,200));

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

                } else if (carY + car.getImage().getHeight() > height || carY < 0) {
                    car.stopEngine();
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();
                }

                else if (car instanceof Volvo240 && volvoworkshopPosition.distance(car.getPosition()) < 3) {
                    volvoworkshop.loadCar((Volvo240) car); // born to code, forced to cast.
                    images.set(i, null); // this is stupid. When tuple implementation remove this.
                }


                if (!imageRenderingLimiter) { // only add images in first frame. //VI MÅSTE ÄNDRA så images och positions är i en tuple eller ha en typ DrawableObject med ett imageattribut och ett positionsattribut
                    images.add(car.getImage());
                    points.add(car.getPosition());
                } else {
                    points.set(i, car.getPosition());
                }
            }

            if (!imageRenderingLimiter) {
                images.add(volvoworkshopImage);
                points.add(volvoworkshopPosition);
            }

            imageRenderingLimiter = true;
            frame.drawPanel.prePaint(points, images);
            frame.drawPanel.repaint(); // repaint() calls the paintComponent method of the panel

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

    void turboOn() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vehicle car : vehicles) {
            if (car instanceof Scania) {
                ((Scania) car).raiseBed();
            }
        }
    }

    void lowerBed() {
        for (Vehicle car : vehicles) {
            if (car instanceof Scania) {
                ((Scania) car).lowerBed();
            }
        }
    }
}
