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
    ArrayList<BufferedImage> images = new ArrayList<>();

    HashMap<BufferedImage, Point> vehiclePoints = new HashMap<>();

    void moveit(int x, int y, BufferedImage vehicle){
        this.vehiclePoints.put(vehicle, new Point(x, y));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, HashMap<BufferedImage, Point> vehiclePoints) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehiclePoints = vehiclePoints;
        vehiclePoints.forEach((key, value) -> {
            this.images.add(key);
        });
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(BufferedImage image: images) {
            Point point = vehiclePoints.get(image);
            g.drawImage(image, point.x, point.y, null); // see javadoc for more info on the parameters
        }
    }
}