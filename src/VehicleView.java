import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This class represents the full view of the MVC pattern of your vehicle simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class VehicleView implements MovementListener{
    private JFrame frame = new JFrame();
    int X;
    int Y;

    ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();
    DrawPanel drawPanel;
    HashMap<Vehicle, BufferedImage> vehicleImages = new HashMap<>();


    // Constructor
    public VehicleView(JFrame frame, String framename, HashMap<Vehicle, BufferedImage> vehicleImages, int X, int Y){
        this.frame = frame;
        this.vehicleImages = vehicleImages;
        HashMap<BufferedImage, Point> bufferedImagePointHashMap = new HashMap<>();
        vehicleImages.forEach((vehicle, image) -> {
            bufferedImagePointHashMap.put(image, new Point((int) vehicle.getPosition()[0], (int) vehicle.getPosition()[1]));
        });
        this.X = X;
        this.Y = Y;
        this.drawPanel = new DrawPanel(X, Y-240, bufferedImagePointHashMap);
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.frame.setTitle(title);
        this.frame.setPreferredSize(new Dimension(X,Y));
        this.frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.frame.add(drawPanel);

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.frame.setLocation(dim.width/2-this.frame.getSize().width/2, dim.height/2-this.frame.getSize().height/2);
        this.frame.pack();
        // Make the frame visible
        this.frame.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update(int x, int y, Vehicle vehicle) {
        System.out.println(Arrays.toString(new int[]{x, y}));
        drawPanel.moveit(x, y, this.vehicleImages.get(vehicle));
        frame.repaint();
    }
}