import java.awt.*;
import java.util.Stack;

public class TransportTruck extends Car{

    private Stack cargoStack;
    private double loadDistance;
    private boolean rampDown; // The position of the ramp. Ramp down means truck can't move and cars can board.
    public TransportTruck() {
        super(2, Color.green, 500, "TransportTruck");
        rampDown = false;
        loadDistance = 0.1;
    }
    protected boolean getRampDown(){
        return rampDown;
    }
    public void changeRampPos(){
        // Set function: If the ramp is down, change to up. Vice versa.
        if(!rampDown && currentSpeed == 0){
            rampDown = true;
        }
        else{
            rampDown = false;
        }
    }

    @Override
    public void move(){
        // Truck can only move when ramp is up
        if(!rampDown){
            super.move();
        }
    }

    public void loadCar(Car car){
        if (getDirection() == car.getDirection()){
            if (getPosition().distance(car.getPosition()) < loadDistance
        }


            cargoStack.push(car);
    }

}
