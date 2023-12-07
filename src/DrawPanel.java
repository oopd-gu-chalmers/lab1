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
    public DrawPanel(int x, int y, ArrayList<BufferedImage> images) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.images = images;
        // Print an error message in case file is not found with a try/catch block
        for(BufferedImage image: this.images){
            this.vehiclePoints.put(image, new Point(0, 0));
        }
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