import java.util.Iterator;

public class StackLoader<T> extends Loader<T> implements Iterable<T> {
    public StackLoader(int maxLoadables) {
        super(maxLoadables);
    }

    @Override
    protected T unloadImpl() {
        T car = loadedCars.getLast();
        loadedCars.removeLast();
        return car;
    }

    @Override
    public Iterator<T> iterator() {
        return loadedCars.iterator();
    }
}
