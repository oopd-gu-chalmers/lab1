import java.util.ArrayList;
import java.util.List;


public abstract class Loader<T> implements Loadable<T> {
    protected ArrayList<T> loadedCars;
    private int maxLoadables;


    public Loader(int maxLoadables) {
        this.maxLoadables = maxLoadables;
        this.loadedCars = new ArrayList<>();


    }


    @Override
    public void load(T car) {
        if (loadedCars.size() < maxLoadables){
            loadedCars.addLast(car);
        }
        else {
            throw new IllegalStateException("Cannot load more cars!");
        }
    }

    @Override
    public T unload() {
        if (!loadedCars.isEmpty()){
            return unloadImpl();
        }
        else {
            throw new IllegalStateException("Cannot unload more cars!");
        }
    }
    protected abstract T unloadImpl();
}
