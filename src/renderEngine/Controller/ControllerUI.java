package renderEngine.Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerUI extends JPanel {
    private JPanel gasPanel = new JPanel();
    private JSpinner amountSpinner = new JSpinner();
    private int amount = 0;
    private JLabel gasLabel = new JLabel("Gas/Brake #");
    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton extendTrayButton = new JButton("Scania Extend Tray");
    private JButton retractTrayButton = new JButton("Retract Tray");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");


    public void initUI(JFrame frame, Controller controller) {
        createSpinnerModel();
        createGasPanel();
        createUI(frame);
        createButton(frame, startButton, Color.blue, Color.green);
        createButton(frame, stopButton, Color.red, Color.black);
        addActionListenerToAllButtons(controller);
    }

    private void createUI(JFrame frame) {
        this.setLayout(new GridLayout(2,5));
        this.add(gasPanel, 0);
        this.add(gasButton, 1);
        this.add(turboOnButton, 2);
        this.add(extendTrayButton, 3);
        this.add(startButton, 4);

        this.add(new JPanel(), 5);
        this.add(brakeButton, 6);
        this.add(turboOffButton, 7);
        this.add(retractTrayButton, 8);
        this.add(stopButton, 9);

        this.setPreferredSize(new Dimension((frame.getX())-100, 200));
        this.setBackground(Color.CYAN);
    }

    private void createButton(JFrame frame, JButton startButton, Color blue, Color green) {
        startButton.setBackground(blue);
        startButton.setForeground(green);
        startButton.setPreferredSize(new Dimension(frame.getX() / 5 - 15, 200));
    }


    private void addActionListenerToAllButtons(Controller controller) {
        //TODO
        // - Can probably make lambda function for it or some shit

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.gas(amount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.brake(amount);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.start();
            }
        });
    }


    private void createGasPanel() {
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(amountSpinner, BorderLayout.PAGE_END);
    }


    private void createSpinnerModel() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        amountSpinner = new JSpinner(spinnerModel);
        amountSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                amount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    }

}
