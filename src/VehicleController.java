import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class VehicleController {
    ArrayList<JButton> expectedButtons = new ArrayList<>();
    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all vehicles");
    JButton stopButton = new JButton("Stop all vehicles");
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
    public JFrame createFrameWithButtons(int X, int Y) {
        JFrame frame = new JFrame();
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        frame.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        frame.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        frame.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        frame.add(stopButton);

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        });
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof Turbo) {
                        ((Turbo) vehicle).setTurboOn();
                    }
                }
            }
        });
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof Turbo) {
                        ((Turbo) vehicle).setTurboOff();
                    }
                }
            }
        });
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof Back) {
                        ((Back) vehicle).raiseBack();
                    }

                }
            }
        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof Back) {
                        ((Back) vehicle).lowerBack();
                    }
                }
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.startEngine();
                }
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.stopEngine();
                }
            }
        });
        // Make the frame pack all it's components by respecting the sizes if possible.
        return frame;
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
                    movementListener.update((int) vehicle.getPosition()[0], (int) vehicle.getPosition()[1], vehicle);
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
