package assets.elements.vehicles.engines;

public class TurboEngine extends Engine{
    private final double turboFactor;
    private boolean turboOn;
    public TurboEngine(double enginePower, double turboFactor, double weight){
        super(enginePower, weight);
        this.turboFactor = turboFactor;
        setTurboOff();
    }

    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double getGeneratedPower(){
        if (turboOn) return turboFactor * super.getGeneratedPower();
        return super.getGeneratedPower();
    }
}
