import java.awt.*;

public class Scania extends Truck{

    private BedWithAngleComponent bed;

    public Scania(){
        super(2,500, Color.CYAN, "ScaniaTruck", 1234);
        this.bed = new BedWithAngleComponent();
    }

    public boolean isBedUp(){
        return this.bed.isBedUp();
    }

    public boolean isBedDown(){
        return this.bed.isBedDown();
    }

    public void raiseBed(){
        this.bed.raiseBed(getCurrentSpeed());
    }

    public void lowerBed(){
        this.bed.lowerBed(getCurrentSpeed());
    }

}
