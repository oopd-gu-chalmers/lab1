import java.awt.image.BufferedImage;

public interface MovementListener {
    void updateMovement(int x, int y, Vehicle vehicle);
    void removeVehicle(Vehicle vehicle);
    void addVehicle(Vehicle vehicle);
}
