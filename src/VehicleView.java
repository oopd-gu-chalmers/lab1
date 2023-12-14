import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**
 * This class represents the full view of the MVC pattern of your vehicle simulator.
 * It initializes with being center on the screen and attaching its controller in its state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/

public class VehicleView implements MovementListener{
    private final JFrame frame;
    int X;
    int Y;

    DrawPanel drawPanel;

    // Constructor
    public VehicleView(JFrame frame, String frameName, HashMap<Vehicle, BufferedImage> vehicleImages, int X, int Y){
        this.frame = frame;
        this.X = X;
        this.Y = Y;
        this.drawPanel = new DrawPanel(X, Y-240, vehicleImages);
        initComponents(frameName);
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

    public void updateMovement(Vehicle vehicle) {
        //drawPanel.moveit(vehicle);
        frame.repaint();
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        drawPanel.removeVehicle(vehicle);
        frame.repaint();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getName() + ".jpg")));
            drawPanel.addVehicle(vehicle, image);
        }
        catch (IOException e) {
            System.out.println("Could not find picture " + vehicle.getName() + ".jpg");
        }
        frame.repaint();
    }
}