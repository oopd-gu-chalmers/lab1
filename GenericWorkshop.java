import java.awt.*;

class GenericWorkshop <V extends Vehicle> {

    private LoadComponent loadComponent;

    public GenericWorkshop(int maxCapacity) {
        this.loadComponent = new LoadComponent(maxCapacity);

    }

    public void loadCar(V car) {
        loadComponent.load(car);
    }

    public V unloadCar() {
        Vehicle unloadedCar = this.loadComponent.unload();
        if (unloadedCar != null) {
            return (V) unloadedCar; // jag hoppas detta funkar
        }
        return null;
    }


}

