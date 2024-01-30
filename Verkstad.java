import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Verkstad {
    private List<Car> verkstaden;
    private Point2D.Double position;
    private final int maxCapacity;


    public Verkstad(final int maxCapacity, Point2D.Double position) {
        this.verkstaden = new ArrayList<>();
        this.position = position;
        this.maxCapacity = maxCapacity;
    }

    private boolean hasONECarAllowedInVerkstad() {
        return true;
    }

    public void loadCar(BilTransport transport) {
        if (verkstaden.size() <= maxCapacity) {

            verkstaden.add(car);
        } else
            throw new IllegalArgumentException("verkstaden is full");
    }
}
