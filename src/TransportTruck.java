import java.awt.*;

public class TransportTruck extends Scania { // WEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE

    public TransportTruck(){
        super(2,70, Color.GREEN,"Scania");
        // super(nrDoors,enginePower,color,modelName);
        super.stopEngine();

    }


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
*/