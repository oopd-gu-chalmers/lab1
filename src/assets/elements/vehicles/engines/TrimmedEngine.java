package assets.elements.vehicles.engines;

/**
 * A TrimmedEngine is an Engine with a trim factor.
 * The trim factor is multiplied to the engine power before generating power.
 */
public class TrimmedEngine extends Engine {
    private final double trimFactor;

    /**
     *
     * @param enginePower the maximum power of the engine
     * @param trimFactor the factor which is multiplied to the generated power
     * @param weight the weight of the engine
     */
    public TrimmedEngine(double enginePower, double trimFactor, double weight){
        super(enginePower, weight);
        this.trimFactor = trimFactor;
    }

    @Override
    public double getGeneratedPower(){
        return trimFactor * super.getGeneratedPower();
    }
}
