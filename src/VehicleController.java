import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class VehicleController {
    JPanel controlPanel = new JPanel();
    ModelControl mc;

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
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove Car");

    JButton startButton = new JButton("Start all vehicles");
    JButton stopButton = new JButton("Stop all vehicles");
    // member fields:



    // The frame that represents this instance View of the MVC pattern

    public VehicleController(Stack<Vehicle> vehicles) {
        mc = new ModelControl(vehicles);
    }

    void addListener(MovementListener listener) {
        mc.addListener(listener);
    }

    public JFrame createFrameWithButtons(int X, int Y) {
        JFrame frame = new JFrame();
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner)e.getSource()).getValue());

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        frame.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,6));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(turboOffButton, 6);
        controlPanel.add(removeCarButton, 7);
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

        gasButton.addActionListener(e -> mc.gas(gasAmount));
        brakeButton.addActionListener(e -> mc.brake(gasAmount));
        turboOnButton.addActionListener(e -> mc.setTurboOn());
        turboOffButton.addActionListener(e -> mc.setTurboOff());
        liftBedButton.addActionListener(e -> mc.liftBed());
        lowerBedButton.addActionListener(e -> mc.lowerBed());
        startButton.addActionListener(e -> mc.startEngine());
        stopButton.addActionListener(e -> mc.stopEngine());
        addCarButton.addActionListener(e -> mc.addVehicle());
        removeCarButton.addActionListener(e -> mc.removeVehicle());
        return frame;
    }

   void startTimer() {
        mc.timer.start();
   }

}
