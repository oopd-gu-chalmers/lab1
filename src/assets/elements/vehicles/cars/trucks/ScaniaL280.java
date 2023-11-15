package assets.elements.vehicles.cars.trucks;

import assets.elements.vehicles.engines.Engine;
import assets.elements.vehicles.cars.Truck;

import java.awt.*;

public final class ScaniaL280 extends Truck {
    private static final double maxTrayAngle = 70;
    private double trayAngle;
    public ScaniaL280(){
        super(2, new Engine(300, 500), "ScaniaL280", Color.WHITE, 2.5, 20000);
    }

    public double getTrayAngle() {
        return trayAngle;
    }

    private void setTrayAngle(double angle){
        setTrayRetracted(false);
        trayAngle = angle;

        if (angle <= 0){
            trayAngle = 0;
            setTrayRetracted(true);
        }
        if (angle >= maxTrayAngle){
            trayAngle = maxTrayAngle;
        }
    }
    public void retractTray(double degrees){
        if(isStarted()) {
            System.out.println("Engine must be OFF to move tray");
            return;
        }
        setTrayAngle(trayAngle - degrees);
    }

    public void extendTray(double degrees){
        if(isStarted()) {
            System.out.println("Engine must be OFF to move tray");
            return;
        }
        setTrayAngle(trayAngle + degrees);
    }

    @Override
    public void start(){
        if (isTrayRetracted()) {
            super.start();
        }
    }
}
