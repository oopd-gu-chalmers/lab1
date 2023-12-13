import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class ModelControl {
    private final Stack<Vehicle> vehicles;
    private final int delay = 50;
    final Timer timer = new Timer(delay, new ModelControl.TimerListener());
    ArrayList<MovementListener> movementListeners = new ArrayList<>();

    public ModelControl(Stack<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addListener(MovementListener listener) {
        movementListeners.add(listener);
    }

    void addVehicle() {
        if (vehicles.size() < 10) {
            Vehicle newVehicle = new Vehicle<>(new Volvo240());
            newVehicle.setPosition(new double[]{160 * (int) (vehicles.size() / 3), 160 * (int) (vehicles.size() % 3)});
            vehicles.push(newVehicle);
            for (MovementListener movementListener : movementListeners) {
                movementListener.addVehicle(newVehicle);
            }
        }
    }

    void removeVehicle() {
        Vehicle vehicleToBeRemoved = vehicles.pop();
        if (vehicleToBeRemoved != null) {
            for (MovementListener movementListener : movementListeners) {
                movementListener.removeVehicle(vehicleToBeRemoved);
            }
        }
    }

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

    void setTurboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.vehicle instanceof Turbo)
                ((Turbo) vehicle.vehicle).setTurboOn();
        }
    }

    void setTurboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.vehicle instanceof Turbo) {
                ((Turbo) vehicle.vehicle).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.vehicle instanceof Back) {
                ((Back) vehicle.vehicle).raiseBack();
            }
        }
    }

    void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.vehicle instanceof Back) {
                ((Back) vehicle.vehicle).lowerBack();
            }
        }
    }

    void startEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    private void turnVehicleAround(Vehicle vehicle) {
        vehicle.turnLeft();
        vehicle.turnLeft();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();

                if (vehicle.getPosition()[1] > (800 - 240 - 60)) {
                    turnVehicleAround(vehicle);
                }
                if (vehicle.getPosition()[1] < (0)) {
                    turnVehicleAround(vehicle);
                }
                if (vehicle.getPosition()[0] > (800 - 100)) {
                    turnVehicleAround(vehicle);
                }
                if (vehicle.getPosition()[0] < (0)) {
                    turnVehicleAround(vehicle);
                }
                for (MovementListener movementListener : movementListeners) {
                    movementListener.updateMovement(vehicle);
                }
            }
        }
    }
}