import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Verkstad <T extends Car>{
    private List<T> verkstaden;
    private final int maxCapacity;
    private final boolean carAllowed;

    public Verkstad(final int maxCapacity, ArrayList<T> verkstad) {
        this.verkstaden = verkstad;
        this.maxCapacity = maxCapacity;
        this.carAllowed = true;
    }

    public int getCapacity() {
        return verkstaden.size();
    }
    public void loadOn(T car) {
        if (verkstaden.size() < maxCapacity) {
            verkstaden.add(car);
        } else throw new IllegalArgumentException("verkstaden is full");
    }

    public void unLoadCar(T car) {
        if (!verkstaden.isEmpty()) {
            verkstaden.remove(car);
        } else throw new IllegalArgumentException("verkstaden is tom");
    }
}
