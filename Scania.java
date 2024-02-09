import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Scania extends Truck{

    private BedWithAngleComponent bed;

    public Scania(){
        super(2,500, Color.CYAN, "ScaniaTruck", 1234);
        this.bed = new BedWithAngleComponent();
        try {
            this.setImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
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
