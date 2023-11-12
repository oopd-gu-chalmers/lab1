package elements.vehicles.trucks;
import elements.vehicles.Truck;

import java.awt.*;

public final class ManTGX extends Truck{

    public ManTGX(){
        super(2, 450, "ManTGX", Color.RED);
    }

    public void retractTray(){
        setTrayRetracted(true);
    }

    public void extendTray(){
        if (isEngineOn()){
            System.out.println("Engine must be OFF to extend tray");
            return;
        }
        setTrayRetracted(false);
    }

}
