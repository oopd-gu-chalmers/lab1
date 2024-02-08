import java.awt.*;

class GenericWorkshop <V extends Vehicle> {

    private LoadComponent<V> loadComponent;

    public GenericWorkshop(int maxCapacity) {
        this.loadComponent = new LoadComponent<>(maxCapacity);
    }

    public void loadCar(V car) {
        loadComponent.load(car);
    }

    public V unloadCar() { //Shpouldn't be car, should be unloadVehicle but whatever
        V unloadedCar = this.loadComponent.unload();
        return unloadedCar;
    }

    public V unloadCar(int regNum) { //Shouldn't be car, should be unloadVehicle but whatever
        V unloadedCar = this.loadComponent.unload(regNum);
        return unloadedCar;
    }


}

