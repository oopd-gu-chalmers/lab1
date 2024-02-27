import java.awt.*;
import java.util.ArrayList;

public class vehicleFactory {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public vehicleFactory() {
    }

    public static void buildSaab95(int x, int y) {
        if (vehicles.size() < 10) {
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(x, y));
        vehicles.add(saab);}
    }

    public static void buildVolvo240(int x, int y) {
        if (vehicles.size() < 10) {
            Volvo240 volvo = new Volvo240();
            volvo.setPosition(new Point(x,y));
            vehicles.add(volvo);}
    }

    public static void buildScania(int x, int y) {
        if (vehicles.size() < 10) {
            Scania scania = new Scania();
            scania.setPosition(new Point(x, y));
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

    public static void buildRandomCar() {
        int random = (int) (Math.random() * 3);
        int x = (int) (Math.random() * 600);
        int y = (int) (Math.random() * 500);
        if (random == 0) {
            buildSaab95(x,y);
        } else if (random == 1) {
            buildVolvo240(x,y);
        } else {
            buildScania(x,y);
        }
    }
}
