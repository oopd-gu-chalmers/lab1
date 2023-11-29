import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the vehicle vehicles.

public class DrawPanel extends JPanel{

    ArrayList<Vehicle> vehicles;
    ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
    // To keep track of a singel vehicles position
    ArrayList<Point> vehiclePoints = new ArrayList<>();

    // TODO: Make this genereal for all vehicles
    void moveit(int x, int y, int index){
        Point point = vehiclePoints.get(index);
        point.x = x;
        point.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            for(Vehicle vehicle: this.vehicles){
                this.images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.modelName + ".jpg")));
                this.vehiclePoints.add(new Point(0, 0));
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(BufferedImage image: images) {
            Point point = vehiclePoints.get(images.indexOf(image));
            g.drawImage(image, point.x, point.y, null); // see javadoc for more info on the parameters
        }
    }
}