package assets.elements.vehicles.boats;

import assets.Startable;
import assets.elements.vehicles.engines.Engine;

import java.awt.*;

/**
 * A MotorizedBoat is a Boat which is Startable.
 * It has an Engine which can be controlled with a throttle.
 */
public abstract class MotorizedBoat extends Boat implements Startable {
    private Engine engine;
    private boolean started;
    private double throttleLevel;
    public MotorizedBoat(Engine engine, String modelName, Color color, double height, double weight, double maximumSwing) {
        super(modelName, color, height, weight, maximumSwing);
        this.engine = engine;
        stop();
    }

    public void start(){
        started = true;
        engine.start();
    }
    public void stop(){
        started = false;
        throttleLevel = 0;
        engine.stop();
    }
    public boolean isStarted(){
        return started;
    }

    public void setThrottle(double level){
        if (!isStarted()){
            System.out.println("Boat must be started to use throttle!");
            return;
        }
        if (level < 0 || level > 1){
            System.out.println("Throttle level must be in range [0,1]");
            return;
        }
        throttleLevel = level;
        setSpeed(engine.getGeneratedPower() * level);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


    @Override
    public double getWeight() {
        return super.getWeight() + engine.getWeight();
    }
}
