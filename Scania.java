import java.awt.*;

public class Scania extends Truck{

    public Scania(){
        super(2,500, Color.CYAN, "ScaniaTruck");
    }

    protected double speedFactor(){
        return 5;
    }
}
