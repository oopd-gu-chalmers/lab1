import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class VehicleController implements ActionListener{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    final Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    // A list of vehicles, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<MovementListener> movementListeners= new ArrayList<>();

    public void addListener(MovementListener listener) {
        movementListeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
                    turnVehicleAround(vehicle);
                }
                if (vehicle.getPosition()[1] < (0)) {
                    turnVehicleAround(vehicle);
                }
                if (vehicle.getPosition()[0] > (800-100)) {
                    turnVehicleAround(vehicle);
                }
                if (vehicle.getPosition()[0] < (0)) {
                    turnVehicleAround(vehicle);
                }
                for (MovementListener movementListener: movementListeners) {
                    movementListener.update(vehicle.getPosition()[0], vehicle.getPosition()[1], vehicle);
                }
            }
        }

        private static void turnVehicleAround(Vehicle vehicle) {
            vehicle.turnLeft();
            vehicle.turnLeft();
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
