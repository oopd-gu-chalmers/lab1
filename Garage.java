public class Garage {

    private int capacity; //nr of cars that can be stored
    private String[] acceptedModels; //Models that the garage accepts
    private boolean acceptsAllModels; //If the garage accepts all models
    private Car[] cars = new Car[capacity]; //Array of cars in the garage

    public Garage(int capacity, String[] acceptedModels, boolean acceptsAllModels) {
        this.capacity = capacity;
        this.acceptedModels = acceptedModels;
        this.acceptsAllModels = acceptsAllModels;
    }

    public boolean checkCarAccepted(Car car) {
        if (acceptsAllModels) {return true;}
        else {
            for (String model : acceptedModels) {
                if (car.getModelName().equals(model)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void addCar(Car car) throws Exception {
        if (checkCarAccepted(car)) {
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] == null) {
                    cars[i] = car;
                    break;
                }
                else if (i == cars.length - 1) {throw new Exception("Garage is full");}
            }
        }
        else {throw new Exception("Garage does not accept this model"); }
    }

    public void removeCar(Car car) throws Exception {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == car) {
                cars[i] = null;
                break;
            }
            else if (i == cars.length - 1) {throw new Exception("Car not found");}
        }
    }
}