package assets.storages;
import assets.elements.Element;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StorageQueue<T extends Element> extends Storage<T>{

    private final Queue<T> queueItems;
    public StorageQueue(Element owner, int size) {
        super(new LinkedList<>(), owner, size);
        this.queueItems = (Queue<T>) getStorageItems();
    }

    public T poll() {
        if (getItemCount() == 0) return null;
        T element = queueItems.poll();
        element.demount();
        return element;
    }

    public T poll(double[] position) {
        if (getItemCount() == 0) return null;
        T element = queueItems.poll();
        element.demount(position);
        return element;
    }


}
