package assets.elements.vehicles.engines;

/**
 * An Engine is an Element which can generate power.
 * It can be started and stopped.
 * An Engine has a weight.
 */
public class Engine {
    private final double enginePower;
    private final double weight;
    private boolean engineOn;
    public Engine(double enginePower, double weight){
        this.enginePower = enginePower;
        this.weight = weight;
    }

    /**
     * @return true if engine is on, false otherwise
     */
    public boolean isEngineOn() {
        return engineOn;
    }

    /**
     * Start the engine
     */
    public void start(){
        engineOn = true;
    }

    /**
     * Stop the engine
     */
    public void stop(){
        engineOn = false;
    }

    /**
     * @return the maximum power of the engine
     */
    public double getMaxEnginePower(){
        return enginePower;
    }

    /**
     * @return The generated power of the engine
     */
    public double getGeneratedPower() {
        return getMaxEnginePower() * 0.01;
    }

    /**
     * @return the weight of the engine
     */
    public double getWeight() {
        return weight;
    }
}
