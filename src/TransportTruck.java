import java.awt.*;

public class TransportTruck extends Scania { // WEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE



    @Override
    public void raiseBedAngle() {
        if (getCurrentSpeed() == 0) {
            getBedAngle() = 70;
        }
    }
    @Override
    public void lowerBedAngle() {
        if (getCurrentSpeed() == 0) {
            bedAngle = 0;
        }
    }
}
