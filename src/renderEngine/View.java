package renderEngine;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/
//TEST
public class View extends JFrame implements Channel{
    private static final int X = 800;
    private static final int Y = 800;
    // The controller member
    private GameView gameView;
    private Controller controller;
    private JPanel controlPanel = new JPanel();

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

    public View(String frameName, Controller controller){
        this.controller = controller;
        this.gameView = new GameView(X, Y-240, controller.cars);
        setupView(frameName);

        this.add(gameView);

        initControlPanel();
        this.add(controlPanel);
    }

    @Override
    public void update() {
        //System.out.println("(CAR VIEW) UPDATE IN");
        this.gameView.repaint();
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void setupView(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setUpFrame();
    }

    private void setUpFrame() {
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // ---- CONTROLLER -----

    private void initControlPanel() {
        createSpinnerModel();
        createGasPanel();
        createControlPanel();
        createButton(startButton, Color.blue, Color.green);
        createButton(stopButton, Color.red, Color.black);
        addActionListenerToAllButtons();
    }

    private void createControlPanel() {
        controlPanel.setLayout(new GridLayout(2,5));
        controlPanel.add(gasPanel, 0);
        controlPanel.add(gasButton, 1);
        controlPanel.add(turboOnButton, 2);
        controlPanel.add(extendTrayButton, 3);
        controlPanel.add(startButton, 4);

        controlPanel.add(new JPanel(), 5);
        controlPanel.add(brakeButton, 6);
        controlPanel.add(turboOffButton, 7);
        controlPanel.add(retractTrayButton, 8);
        controlPanel.add(stopButton, 9);

        controlPanel.setPreferredSize(new Dimension((X)-100, 200));
        controlPanel.setBackground(Color.CYAN);
    }

    private void createButton(JButton startButton, Color blue, Color green) {
        startButton.setBackground(blue);
        startButton.setForeground(green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
    }


    private void addActionListenerToAllButtons() {
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