package src;
import java.util.Stack;

public class Nischverkstad extends Verkstad{
    private Car carmodel;
    private Stack<Car> cargo;

    public Nischverkstad(int maxsize, Car carmodel){
        super(maxsize);
        this.cargo = new Stack<>();
        this.carmodel = carmodel;

    }
    public boolean falsifyModel(Car car){
        if (car == carmodel){
            return false;
        }
        else {
            return true;
        }
    }
    public void loadCargo(Car car) {
        if (this.cargo.size() == this.getMaxsize()) {
            throw new RuntimeException("Verkstad full");
        }
        else if (falsifyModel(car)) {
            throw new RuntimeException("Wrong model");
        }
        else {
            this.cargo.push(car);
        }
    }
    public void offLoadCargo(){
        if (this.cargo.size() == 0){
            throw new RuntimeException("Verkstad already empty");
        }
        else
        {this.cargo.pop();}

    }
}
