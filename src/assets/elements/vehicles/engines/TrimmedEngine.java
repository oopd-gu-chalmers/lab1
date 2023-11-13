package assets.elements.vehicles.engines;

import assets.elements.Element;
import assets.elements.vehicles.Engine;

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
