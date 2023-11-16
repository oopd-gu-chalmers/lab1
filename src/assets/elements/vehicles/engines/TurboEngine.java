package assets.elements.vehicles.engines;

/**
 * A TurboEngine is an Engine with a turbo which can be toggled On and Off.
 */
public class TurboEngine extends Engine{
    private final double turboFactor;
    private boolean turboOn;

    /**
     * Create a new TurboEngine
     * @param enginePower the maximum power of the engine
     * @param turboFactor the factor which is multiplied to generated power when turbo is On
     * @param weight the weight of the engine
     */
    public TurboEngine(double enginePower, double turboFactor, double weight){
        super(enginePower, weight);
        this.turboFactor = turboFactor;
        setTurboOff();
    }

    /**
     * Turn the turbo On
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Turn the turbo Off
     */
    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double getGeneratedPower(){
        if (turboOn) return turboFactor * super.getGeneratedPower();
        return super.getGeneratedPower();
    }
}
