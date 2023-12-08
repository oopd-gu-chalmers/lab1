import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the vehicle vehicles.

public class DrawPanel extends JPanel {
    HashMap<Vehicle, BufferedImage> vehicleImages = new HashMap<>();

    HashMap<BufferedImage, Point> vehiclePoints = new HashMap<>();

    void moveit(int x, int y, Vehicle vehicle) {
        this.vehiclePoints.put(vehicleImages.get(vehicle), new Point(x, y));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, HashMap<BufferedImage, Point> vehiclePoints, HashMap<Vehicle, BufferedImage> vehicleImages) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehiclePoints = vehiclePoints;
        this.vehicleImages = vehicleImages;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vehicleImages.forEach((vehicle, image) -> {
            Point point = vehiclePoints.get(image);
            g.drawImage(image, point.x, point.y, null); // see javadoc for more info on the parameters
        });
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehiclePoints.remove(this.vehicleImages.get(vehicle));
        this.vehicleImages.remove(vehicle);
    }

    public void addVehicle(Vehicle vehicle, BufferedImage image) {
        this.vehicleImages.put(vehicle, image);
        Point newPoint = new Point((int) vehicle.getPosition()[0], (int) vehicle.getPosition()[1]);
        this.vehiclePoints.put(image, newPoint);
    }
}