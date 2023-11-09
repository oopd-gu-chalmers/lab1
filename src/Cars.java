import java.awt.*;
import java.awt.geom.Point2D;

import static java.lang.System.out;

public abstract class Cars implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Point2D position;
    public Direction direction;


    public Cars(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = new Point2D.Double(0.0F,0.0F);
        this.direction = Direction.NORTH;

    }
    public void gas(double amount){incrementSpeed(amount);}

    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);
    public abstract double speedFactor();
    public boolean turboOn;
    private double currentSpeed; // The current speed of the car
    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
    public void move(){
        switch(this.direction){
            case NORTH:
                this.position.setLocation(this.position.getX(),(this.position.getY()+getCurrentSpeed()));
                break;
            case EAST:
                this.position.setLocation((this.position.getX()+getCurrentSpeed()),this.position.getY());
                break;
            case SOUTH:
                this.position.setLocation(this.position.getX(),(this.position.getY()-getCurrentSpeed()));
                break;
            case WEST:
                this.position.setLocation((this.position.getX()-getCurrentSpeed()),this.position.getY());
                break;
        }
    }
    public void turnLeft(){
        switch(this.direction){
            case NORTH:
                this.direction = Direction.WEST;
                break;
            case WEST:
                this.direction = Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction.EAST;
                break;
            case EAST:
                this.direction = Direction.NORTH;
        }
    }
    public void turnRight(){
        switch(this.direction){
            case NORTH:
                this.direction = Direction.EAST;
                break;
            case EAST:
                this.direction = Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction.WEST;
                break;
            case WEST:
                this.direction = Direction.NORTH;
        }

    }
    public double getPositionX(){return this.position.getX();}
    public double getPositionY(){return this.position.getY();}


    public void setCurrentSpeed(double amount){
        this.currentSpeed = amount;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public String getmodelName(){
        return modelName;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
}

class Volvo240 extends Cars {
    private final double trimfactor;
    public Volvo240(){
        super(4,100,Color.black,"Volvo240");
        // super(nrDoors,enginePower,color,modelName);
        this.trimfactor = 1.25;
        super.stopEngine();
    }
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimfactor;
    }
    @Override
    public void incrementSpeed(double amount){
        super.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }   // Current speed not set
    @Override
    public void decrementSpeed(double amount){
        super.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }   // Current speed not set
}

class Saab95 extends Cars {
    private boolean turboOn;
    public Saab95(){
        super(2,125,Color.red,"Saab95");
        // super(nrDoors,enginePower,color,modelName);
        this.setTurboOff();
        super.stopEngine();
    }
    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){
        super.setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }
    @Override
    public void decrementSpeed(double amount){
        super.setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }


}

class Main {
    public static void main(String[] args) {

        //Cars myCars = new Cars();
        Saab95 mySaab95 = new Saab95();
        Volvo240 myVolvo240 = new Volvo240();
        /*
        //out.println(mySaab95.getNrDoors());
        //out.println(mySaab95.nrDoors);
        out.println(myVolvo240.getNrDoors());
        out.println(myVolvo240.speedFactor());
        out.println(myVolvo240.getCurrentSpeed());
        myVolvo240.incrementSpeed(2);
        out.println(myVolvo240.getCurrentSpeed());
        myVolvo240.incrementSpeed(2);
        out.println(myVolvo240.getCurrentSpeed());
        out.println(mySaab95.getCurrentSpeed());
        mySaab95.setTurboOn();
        out.println(mySaab95.speedFactor());
        */
        mySaab95.gas(40);
        mySaab95.move();
        mySaab95.turnLeft();
        mySaab95.move();
        mySaab95.gas(17.5);
        mySaab95.turnRight();
        mySaab95.move();
        out.println(mySaab95.getPositionX());
        out.println(mySaab95.getPositionY());
    }
}