package assets.elements.vehicles.engines;

public class TrimmedEngine extends Engine {
    private final double trimFactor;
    public TrimmedEngine(double enginePower, double trimFactor, double weight){
        super(enginePower, weight);
        this.trimFactor = trimFactor;
    }

    @Override
    public double getGeneratedPower(){
        return trimFactor * super.getGeneratedPower();
    }
}
