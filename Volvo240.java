import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
        stopEngine();
        // använder super för att få tillgång till car konstruktionen för att slippa göra egna variabler
    }

    private double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
    @Override
    protected void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }
    @Override
    protected void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));

    }

}
