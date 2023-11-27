import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class    CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>(); //Zeldia: Från ACar --> Car

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Car[] carsToBeAdded = {new Volvo240(), new Saab95(), new Scania()};

        int carIndex = 0;
        for(Car car: carsToBeAdded) {
           double[] position = {100 * carIndex, 0};
            car.setPosition(position);
            cc.cars.add(car);
            carIndex++;
        }

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
            for (Car car : cars) { //Zeldia: Från ACar --> Car
                car.move();
                //int temp = 200;
                //if (car.getPosition()[1] > temp) {
                //    int x = (int) Math.min(car.getPosition()[1], 200);
                //} else {
                //    int x = (int) Math.round(car.getPosition()[0]); //Zeldia: Från .getX() --> [0]
                //}



                int x = (int) Math.min(Math.round(car.getPosition()[0]), (800-100));
                int y = (int) Math.min(Math.round(car.getPosition()[1]), (800-240-60));
                if (car.getPosition()[1] > (800-240-60)) {
                    car.turnLeft();
                    car.turnLeft();
                    //car.setPosition(new double[]{car.getPosition()[0], (800 - 240 - 60)});
                    //vad gör new double????
                }
                if (car.getPosition()[1] < (0)) {
                    car.turnLeft();
                    car.turnLeft();
                    //car.setPosition(new double[]{car.getPosition()[0], 0});
                    //vad gör new double????
                }
                if (car.getPosition()[0] > (800-100)) {
                    car.turnLeft();
                    car.turnLeft();
                    //car.setPosition(new double[]{(800 - 100),car.getPosition()[1]});
                }
                if (car.getPosition()[0] < (0)) {
                    car.turnLeft();
                    car.turnLeft();
                    //car.setPosition(new double[]{(0),car.getPosition()[1]});
                }
                frame.drawPanel.moveit(x, y);
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
}
