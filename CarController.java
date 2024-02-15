import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Car v0 = new Volvo240();
        cc.cars.add(v0);

        Car s0 = new Saab95();
        s0.setxPos(0);
        s0.setyPos(200);
        cc.cars.add(s0);

        Car sc0 = new Scania();
        sc0.setxPos(0);
        sc0.setyPos(400);
        cc.cars.add(sc0);



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);


        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getxPos());
                int y = (int) Math.round(car.getyPos());
                frame.drawPanel.addCar(car);
                frame.drawPanel.moveit(car, x, y);
                System.out.println(car.getxPos());
                if(car instanceof Scania) {
                    System.out.println(((Scania) car).getRamp().getAngle());
                }
                if(car instanceof Volvo240) {
                    loadVolvo((Volvo240) car);
                }
                if (x > frame.drawPanel.getWidth() - 100) {
                    car.setDirection(3);
                }
                if (x < 0) {
                    car.setDirection(1);
                } else
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car c : cars) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car c : cars) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOff();
            }
        }
    }

    void raiseFlak() {
        for(Car c : cars) {
            if (c instanceof Scania) {
                ((Scania) c).raiseRamp();
            }
        }
    }
    void lowerFlak() {
        for(Car c : cars) {
            if (c instanceof Scania) {
                ((Scania) c).lowerRamp();
            }
        }
    }

        void stopAllCars() {
            for (Car c : cars) {
                c.stopEngine();
            }
        }
        void startAllCars() {
            for(Car c : cars) {
                c.startEngine();
            }
        }

    void loadVolvo(Volvo240 car) {
        Verkstad<Volvo240> verkstad = new Verkstad<>(5, frame.drawPanel.volvoWorkshopPoint);
            if(car.getxPos() >= frame.drawPanel.volvoWorkshopPoint.x) {
                verkstad.add(car);
                car.setxPos(frame.drawPanel.volvoWorkshopPoint.x);
                car.setyPos(frame.drawPanel.volvoWorkshopPoint.y);
        }
    }
}
