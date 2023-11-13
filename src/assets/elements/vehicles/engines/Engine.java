package assets.elements.vehicles.engines;

import assets.elements.Element;

public class Engine {
    private final double enginePower;
    private final double weight;
    private boolean engineOn;
    public Engine(double enginePower, double weight){
        this.enginePower = enginePower;
        this.weight = weight;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    public void start(){
        if (engineOn) {
            System.out.println("Engine is already ON");
            return;
        }
        engineOn = true;
    }

    public void stop(){
        if (!engineOn) {
            System.out.println("Engine is already OFF");
            return;
        }
        engineOn = false;
    }

    public double getEnginePower(){
        return enginePower;
    }
    public double getGeneratedPower() {
        return getEnginePower() * 0.01;
    }

    public double getWeight() {
        return weight;
    }
}
