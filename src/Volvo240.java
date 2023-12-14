import java.awt.*;

public class Volvo240 extends Car{

    protected final static double trimFactor = 1.25;

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
