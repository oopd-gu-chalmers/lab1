import java.util.Objects;
import java.util.Vector;



public class Workshop<C> {
    private final int maxCars;
    //private final String modelName;
    public Vector<C> cars = new Vector<>();

    public Workshop(int maxCars) {
        this.maxCars = maxCars;
        //this.modelName = "Null";
    }

    public Workshop(String modelName, int maxCars) {
        //this.modelName = modelName;
        this.maxCars = maxCars;
    }


    public void addCar(C car) {
        cars.add(car);
    }
    /*
    public void addCar(Volvo240 volvo) {
        cars.add(volvo);
    }

    public void addCar(Saab95 saab) {
        cars.add(saab);
    }




    public void addCar(Car car) {
        if ((Objects.equals(car.modelName, this.modelName) || Objects.equals(this.modelName, "Null")) && cars.size() < maxCars)
            cars.add(car);
    }

     */

    public void removeCar(C car) {
        cars.remove(car);
    }



}
