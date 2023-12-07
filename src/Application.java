import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Application extends JFrame{
    public static void main(String[] args) {
        int X = 800;
        int Y = 800;
        Vehicle[] vehicles = {
                new Vehicle<Car>(new Volvo240()),
                new Vehicle<Car>(new Saab95()),
                new Vehicle<>(new Scania())
        };

        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        for(Vehicle vehicle : vehicles) {
            try {
                images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getName() + ".jpg")));
            }
            catch (IOException e) {
            }
        }

        VehicleController vc = new VehicleController();
        JFrame frame = vc.createFrameWithButtons(X, Y);
        int vehicleIndex = 0;
        for(Vehicle vehicle: vehicles) {
            double[] position = {0, 160 * vehicleIndex};

            vehicle.setPosition(position);
            vc.vehicles.add(vehicle);
            vehicleIndex++;
        }

        HashMap<Vehicle, BufferedImage> vehicleBufferedImageHashMap = new HashMap<>();
        for (int i = 0; i < vehicles.length; i++) {
            vehicleBufferedImageHashMap.put(vehicles[i], images.get(i));
        }

        VehicleView vv = new VehicleView(frame, "Car Sim 1.0", vehicleBufferedImageHashMap, X, Y);

        vc.addListener(vv);

        // Start the timer
        vc.timer.start();
    }
}
