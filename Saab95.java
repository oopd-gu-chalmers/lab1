import java.awt.*;

public class Saab95 extends Cars{



    private boolean turboOn;

    public Saab95(){
        super(2, 125, Color.red, "Saab95");
	    turboOn = false;

    }

    private void setTurboOn(){
	    turboOn = true;
    }

    private void setTurboOff(){
	    turboOn = false;
    }
    
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){
        while (currentSpeed < enginePower){
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }

    }

    private void decrementSpeed(double amount){
        if(amount == 0){
            System.out.println("NOT 0");
        }
        else{
            while (currentSpeed > 0){
                currentSpeed = getCurrentSpeed() - speedFactor() * amount;
            }
        }


    }
    
    // TODO fix this method according to lab pm
    protected void gas(double amount){
        if (amount <= 1 && amount >= 0){
            incrementSpeed(amount);
        }
        else{
            System.out.println("Amount outside range");
        }
    }

    // TODO fix this method according to lab pm
    protected void brake(double amount){
        if (amount <= 1 && amount >= 0){
            decrementSpeed(amount);
        }
        else{
            System.out.println("Amount outside range");
        }

    }

    public static void main(String[] args) {
        Saab95 car = new Saab95();
        //double speed = car.currentSpeed;
        System.out.println(car.getColor());
        car.setTurboOn();
        if (car.turboOn){
            System.out.println("OwO");
        }
        car.startEngine();
        car.turnLeft();
        car.move();
        car.turnRight();
        car.move();
        car.turnRight();
        car.move();
    }
}
