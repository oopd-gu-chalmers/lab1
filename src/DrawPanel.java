import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car cars.

public class DrawPanel extends JPanel{

    ArrayList<Car> cars;
    ArrayList<BufferedImage> images = new ArrayList<>();
    // To keep track of a singel cars position
    Point carPoint = new Point();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        carPoint.x = x;
        carPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars = cars;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            for(Car car: this.cars){
                this.images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + car.modelName + ".jpg")));
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
        Iterator<BufferedImage> imageIterator = this.images.iterator();
        int imageIndex = 0;
        while(imageIterator.hasNext()) {
            BufferedImage image = imageIterator.next();
            g.drawImage(image, carPoint.x, carPoint.y, null); // see javadoc for more info on the parameters
            imageIndex++;
        }
    }
}
