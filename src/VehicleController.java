import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class VehicleController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    VehicleView frame;
    // A list of vehicles, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        VehicleController cc = new VehicleController();

        Vehicle[] vehiclesToBeAdded = {new Volvo240(), new Saab95(), new Scania()};

        int vehicleIndex = 0;
        for(Vehicle vehicle: vehiclesToBeAdded) {
           double[] position = {100 * vehicleIndex, 0};
            vehicle.setPosition(position);
            cc.vehicles.add(vehicle);
            vehicleIndex++;
        }

        // Start a new view and send a reference of self
        cc.frame = new VehicleView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the vehicles in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();

                int x = (int) Math.min(Math.round(vehicle.getPosition()[0]), (800-100));
                int y = (int) Math.min(Math.round(vehicle.getPosition()[1]), (800-240-60));
                if (vehicle.getPosition()[1] > (800-240-60)) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }
                if (vehicle.getPosition()[1] < (0)) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }
                if (vehicle.getPosition()[0] > (800-100)) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }
                if (vehicle.getPosition()[0] < (0)) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }
                frame.drawPanel.moveit(x, y, vehicles.indexOf(vehicle));
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each vehicle once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }
}
