public class QueueLoader<T> extends Loader<T>{
    public QueueLoader(int maxLoadables) {
        super(maxLoadables);
    }

    @Override
    protected T unloadImpl() {
        T car = loadedCars.getFirst();
        loadedCars.removeFirst();
        return car;
    }
}
