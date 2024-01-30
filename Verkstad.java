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

    public void unLoadCar(BilTransport transport) {
        if (transport.getFlak().peek() != null && verkstaden.size() <= maxCapacity) {
            Car car = transport.unLoadCar();
            car.getCordination().setLocation(this.position);
            verkstaden.add(car);
        }
    }
    public void loadCar(BilTransport transport) {
        if(!verkstaden.isEmpty() && transport.getFlak().size() < transport.getMaxload()) {
            Car car = verkstaden.remove(verkstaden.size() - 1);
            car.getCordination().setLocation(transport.getCordination());
            transport.loadCar(car);
        }
    }
}
