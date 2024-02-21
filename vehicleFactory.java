import java.awt.*;
import java.util.ArrayList;

public class vehicleFactory {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public vehicleFactory() {
    }

    public void buildSaab95() {
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(0, 100));
        vehicles.add(saab);
    }

    public void buildVolvo240() {
        Volvo240 volvo = new Volvo240();
        vehicles.add(volvo);
    }

    public void buildScania() {
        Scania scania = new Scania();
        scania.setPosition(new Point(0, 200));
        vehicles.add(scania);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
