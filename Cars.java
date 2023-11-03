import java.awt.*;
import static java.lang.System.out;

class Vehicles {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    public void Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        //stopEngine();
    }

    public void Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        //turboOn = false;
        modelName = "Saab95";
        //stopEngine();
    }
}




class Cars extends Vehicles {
    public static void main(String[] args) {
        Cars myCar = new Cars();
        myCar.Saab95();
        out.println(myCar.nrDoors);
        myCar.Volvo240();
        out.println(myCar.nrDoors);
    }

}


