import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.*;

// This panel represent the animated part of the view with the vehicle vehicles.

public class DrawPanel extends JPanel {
    HashMap<Vehicle, BufferedImage> vehicleImages;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, HashMap<Vehicle, BufferedImage> vehicleImages) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicleImages = vehicleImages;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vehicleImages.forEach((vehicle, image) -> {
            Point point = new Point((int) vehicle.getPosition()[0], (int) vehicle.getPosition()[1]);
            g.drawImage(image, point.x, point.y, null); // see javadoc for more info on the parameters
        });
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleImages.remove(vehicle);
    }

    public void addVehicle(Vehicle vehicle, BufferedImage image) {
        vehicleImages.put(vehicle, image);
    }
}