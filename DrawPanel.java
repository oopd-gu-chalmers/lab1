import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoWorkshopImage;
    BufferedImage volvo240Image;
    BufferedImage saab95Image;
    BufferedImage scaniaImage;
    // To keep track of a single car's position
    Point Volvo240 = new Point();
    Point Saab95 = new Point();
    Point Scania = new Point();
    Point volvoWorkshopPoint = new Point(300,0);

    // TODO: Make this general for all cars
    public void moveit(int x, int y, Vehicle car){
        if (car.getModelName().equals("Volvo240")){
        Volvo240.x = x;
        Volvo240.y = y;
        }
        else if (car.getModelName().equals("Saab95")){
        Saab95.x = x;
        Saab95.y = y;
        }
        else if (car.getModelName().equals("Scania")){
        Scania.x = x;
        Scania.y = y;
        }

    }



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
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
        g.drawImage(scaniaImage, Saab95.x, Saab95.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvo240Image, Volvo240.x, Volvo240.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        g.drawImage(saab95Image, Scania.x, Scania.y, null); // see javadoc for more info on the parameters
    }

}
