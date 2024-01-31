import java.util.ArrayList;

abstract class GenericWorkshop implements Capacity {

    private final Vehicle[] cars;
    private int count;
    private Class<?> acceptedCar;


    public GenericWorkshop(int maxCapacity, Class<?> acceptedCars) {
        this.cars = new Vehicle[maxCapacity];
        this.count = 0;
        this.acceptedCar = acceptedCars;
    }

    public GenericWorkshop(int maxCapacity) {
        this.cars = new Vehicle[maxCapacity];
        this.count = 0;
        this.acceptedCar = Vehicle.class;
    }

    @Override
    public void loadCar(Vehicle car) {

        if (count < cars.length && acceptedCar.isInstance(car)) {
            cars[count++] = car;
        }
//        else if(!acceptedCarsList.contains(car)) {
//            throw new IllegalArgumentException("Workshop does not accept this type of car.");
//        }
        else {
            throw new IllegalArgumentException("Workshop is full, cannot load more cars.");
        }
    }

    @Override
    public void unloadCar() {
        if (count > 0) {
            Vehicle car = cars[--count];
            cars[count] = null; // Optionally clear the reference to the unloaded car
        } else {
            System.out.println("No cars to unload.");
        }
    }


}

