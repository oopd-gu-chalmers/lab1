package elements.vehicles.trucks;

import elements.vehicles.Truck;

import java.awt.*;

public final class ScaniaL280 extends Truck {

    private static final double traySpeed = 10;
    private static final double maxTrayAngle = 70;
    private double trayAngle;
    public ScaniaL280(){
        super(2, 300, "ScaniaL280", Color.WHITE);
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
        if(isEngineOn()) {
            System.out.println("Engine must be OFF to move tray");
            return;
        }
        if (degrees < 0 || degrees > traySpeed){
            System.out.printf("Angle must be between 0 and %s", maxTrayAngle);
            return;
        }
        setTrayAngle(trayAngle - degrees);
    }

    public void extendTray(double degrees){
        if(isEngineOn()) {
            System.out.println("Engine must be OFF to move tray");
            return;
        }
        if (degrees < 0 || degrees > traySpeed){
            System.out.printf("Angle must be between 0 and %s", maxTrayAngle);
            return;
        }
        setTrayAngle(trayAngle + degrees);
    }
}
