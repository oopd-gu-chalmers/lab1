import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawObjects extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoWorkshopImage;
    BufferedImage volvo240Image;
    BufferedImage saab95Image;
    BufferedImage scaniaImage;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    // To keep track of a single car's position

    Point volvoWorkshopPoint = new Point(300,0);

    // TODO: Make this general for all cars


    // Initializes the panel and reads the images
    public DrawObjects(int x, int y, ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y-(y/3)));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
            try {
                // You can remove the "pics" part if running outside of IntelliJ and
                // everything is in the same main folder.
                // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

                // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
                // if you are starting in IntelliJ.
                saab95Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
                scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
                volvo240Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
                volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }



    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle car : vehicles) {
            System.out.println(car.getModelName());
            if (car instanceof Volvo240) {
                g.drawImage(volvo240Image, (int) car.getXPosition(), (int) car.getYPosition(), null);
            } else if (car instanceof Scania) {
                g.drawImage(scaniaImage, (int) car.getXPosition(), (int) car.getYPosition(), null);
            } else if (car instanceof Saab95) {
                g.drawImage(saab95Image, (int) car.getXPosition(), (int) car.getYPosition(), null);
            }
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}