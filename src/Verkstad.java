package src;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Stack;

public class Verkstad implements Storage {
    private Stack<Car> cargo;
    private int maxsize;
    public Verkstad(int maxsize){
        this.cargo = new Stack<>();
        this.maxsize = maxsize;
    }
    public int getMaxsize(){
        return this.maxsize;
    }
    public void loadCargo(Car car) {
        if (this.cargo.size() == this.maxsize) {
            throw new RuntimeException("Verkstad full");
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


