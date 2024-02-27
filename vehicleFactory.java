import java.awt.*;
import java.util.ArrayList;

public class vehicleFactory {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public vehicleFactory() {
    }

    public static void buildSaab95() {
        if (vehicles.size() < 10) {
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(0, 100));
        vehicles.add(saab);}
    }

    public static void buildVolvo240() {
        if (vehicles.size() < 10) {
            Volvo240 volvo = new Volvo240();
            vehicles.add(volvo);}
    }

    public void buildScania() {
        if (vehicles.size() < 10) {
            Scania scania = new Scania();
            scania.setPosition(new Point(0, 200));
            vehicles.add(scania);
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public static void scrapCar() {
        //if there is more than one car in the list, remove the last one
        if (vehicles.size() >= 1){vehicles.removeLast();}
    }
}
