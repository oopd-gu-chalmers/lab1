import java.util.ArrayList;

public class Workshop<model extends Car> {
    // Parametrisk polymorfism, specificera vilken typ av bilar Workshop kan hantera
    // E.g. specify that 'type' is a subtype from 'Volvo'
    // A workshop that only can handle Volvo is Workshop<VolvoCar>
    private ArrayList<model> cars;
    private final int capacity;

    //Checks if the workshop only accepts a specific car type, if false it will take all cars
    //private final boolean onlySpecificCar;
    //private final Class <?> acceptedCarType; //The specific car type if the Workshop only takes one


    public Workshop(int capacity){ // boolean onlySpecificCar, Class<?> acceptedCarType) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();
        //this.onlySpecificCar = onlySpecificCar;
        //this.acceptedCarType = acceptedCarType;
    }

    public void addCar(model car) {
        if (cars.size() < capacity) {
            // Is it the valid car type?
            // Will also exceed if the workshop takes all cars
            // Or if the car is an instance of the accepted type
            // if (!onlySpecificCar || acceptedCarType.isInstance(car)) {
            cars.add(car);
            // } else {
            //    throw new IllegalArgumentException("Invalid car " + car.getClass().getSimpleName() +
            //            " This Workshop only accepts cars of type " + acceptedCarType.getSimpleName());
            //}
        }
        else {
            throw new IllegalArgumentException("Workshop is full");
        }
    }

    public void removeCar(model car) {
        if (cars.contains(car)) {
            cars.remove(car);
        }
        else {
            throw new IllegalArgumentException("Car not in workshop");
        }
    }
    public ArrayList<model> getCars() {
        return cars;
    }

}
