import java.awt.*;

public class Volvo240 extends Car {

    protected final static double trimFactor = 1.25; //Gjorde private

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    public double speedFactor() { //Annorlunda mellan bilarna
        return enginePower * 0.01 * trimFactor; //Skillnad i trimfactor, är turbo i Saab
    }
}
