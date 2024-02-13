import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    HashMap<Car, BufferedImage> carImages = new HashMap<Car, BufferedImage>();
    HashMap<Car, Point> carPoints = new HashMap<Car, Point>();
    BufferedImage volvoWorkshopImage;

    // To keep track of a single car's position
    Point volvoPoint = new Point();
    Point saabPoint = new Point(0,200);
    Point scaniaPoint = new Point(0, 400);
    Point volvoWorkshopPoint = new Point(500,0);

    // TODO: Make this general for all cars
    void moveit(Car car, int x, int y) {
        carPoints.put(car, new Point(x,y));
    }
    public void addCar(Car car) {
        try {
            if (car.getModelname().equals("Volvo240")) {
                carImages.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
                carPoints.put(car, volvoPoint);
            } else if (car.getModelname().equals("Saab95")) {
                carImages.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
                carPoints.put(car, saabPoint);
            } else if (car.getModelname().equals("Scania")) {
                carImages.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
                carPoints.put(car, scaniaPoint);
            }

            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
             // Update the car's initial position
        } catch (IOException ex) {
        }
    }
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : carImages.keySet()) {
            Point carPoint = carPoints.get(car);
            BufferedImage carImage = carImages.get(car);
            if(carPoint != null && carImage != null) {
                g.drawImage(carImage, carPoint.x, carPoint.y, null);
            }
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
