package assets.storages;
import assets.elements.Element;

import java.util.Stack;

public class StorageStack<T extends Element> extends Storage<T>{

    private final Stack<T> stackItems;
    public StorageStack(Element owner, int size) {
        super(new Stack<>(), owner, size);
        this.stackItems = (Stack<T>) getStorageItems();
    }


    public T pop() {
        if (getItemCount() == 0) return null;
        T element = stackItems.pop();
        element.demount();
        return element;
    }

    public T pop(double[] position) {
        if (getItemCount() == 0) return null;
        T element = stackItems.pop();
        element.demount(position);
        return element;
    }


}
