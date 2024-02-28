import java.awt.*;
import java.util.ArrayList;

public class vehicleFactory {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public vehicleFactory() {
    }

    public void buildSaab95(int x, int y) {
        if (vehicles.size() < 10) {
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(x, y));
        vehicles.add(saab);}
    }

    public void buildVolvo240(int x, int y) {
        if (vehicles.size() < 10) {
            Volvo240 volvo = new Volvo240();
            volvo.setPosition(new Point(x,y));
            vehicles.add(volvo);}
    }

    public void buildScania(int x, int y) {
        if (vehicles.size() < 10) {
            Scania scania = new Scania();
            scania.setPosition(new Point(x, y));
            vehicles.add(scania);
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void scrapCar() {
        //if there is more than one car in the list, remove the last one
        if (vehicles.size() >= 1){vehicles.removeLast();}
    }

    public void buildRandomCar() {
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
