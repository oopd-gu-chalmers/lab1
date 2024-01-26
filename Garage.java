public class Garage {

    private int capacity; //nr of cars that can be stored
    private String[] acceptedModels; //Models that the garage accepts
    private boolean acceptsAllModels; //If the garage accepts all models
    private Car[] cars = new Car[capacity]; //Array of cars in the garage


    public boolean checkCarAccepted(Car car) {
        if (this.acceptsAllModels) {
            return true;
        }
        else {
            for (String model : this.acceptedModels) {
                if (car.getModelName().equals(model)) {
                    return true;
                }
            }
            return false;
        }
    }


}
