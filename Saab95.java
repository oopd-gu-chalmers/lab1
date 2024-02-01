import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;
    public Saab95(){
        super(2,125, Color.red, "Saab95");
        // använder super för att få tillgång till car konstruktionen för att slippa göra egna variabler
	    turboOn = false;
        stopEngine();
    }
    
    public boolean getTurbo() { return turboOn;}
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    protected void incrementSpeed(double amount){ this.setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount); }
    @Override
    protected void decrementSpeed(double amount){
        this.setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

}
