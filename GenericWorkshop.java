import java.awt.*;

class GenericWorkshop <V extends Vehicle> {

    private LoadComponent<V> loadComponent;

    public GenericWorkshop(int maxCapacity) {
        this.loadComponent = new LoadComponent<>(maxCapacity);
    }

    public void loadCar(V car) {
        loadComponent.load(car);
    }

    public V unloadCar() {
        V unloadedCar = this.loadComponent.unload();
        return unloadedCar;

    }


}

