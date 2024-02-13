import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Verkstad<T extends Car> {
    private List<T> verkstaden;
    private final Point2D position;
    private final int maxCapacity;


    public Verkstad(final int maxCapacity, Point2D position) {
        this.verkstaden = new ArrayList<>();
        this.position = position;
        this.maxCapacity = maxCapacity;
    }

    public int getCapacity() {return verkstaden.size();}

    public void add(T car) {
        if (verkstaden.size() <= maxCapacity) {
            verkstaden.add(car);
        }
        else throw new IllegalArgumentException("verkstaden är full");
     }

    public void remove(T car) {
        if(!verkstaden.isEmpty()) {
            verkstaden.remove(car);
        }
        else throw new IllegalArgumentException("verkstaden är tom");
    }
}
