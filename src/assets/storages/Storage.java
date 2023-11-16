package assets.storages;

import assets.elements.Element;

import java.util.Collection;
import java.util.HashSet;

public class Storage<T extends Element> {
    private final Collection<T> storageItems;
    private final Element owner;
    private final int size;
    protected Storage(Collection<T> storageItems, Element owner, int size){
        this.storageItems = storageItems;
        this.owner = owner;
        this.size = size;
    }

    public Storage(Element owner, int size){
        this.storageItems = new HashSet<>();
        this.owner = owner;
        this.size = size;
    }

    public void add(T element){
        if (storageItems.size() >= size){
            System.out.printf("%s is full%n", getOwner());
            return;
        }
        storageItems.add(element);
        element.mount(this);
    }

    public void remove(T element){
        if (!storageItems.remove(element)) {
            System.out.printf("%s does not contain %s%n", getOwner(), element);
            return;
        }
        element.demount();
    }
    public void remove(T element, double[] position){
        if (!storageItems.remove(element)) return;
        element.demount(position);
    }

    public Element getOwner(){
        return owner;
    }
    public int getSize() {
        return size;
    }
    public int getItemCount(){
        return storageItems.size();
    }

    public Collection<T> getStorageItems(){
        return storageItems;
    }
}
