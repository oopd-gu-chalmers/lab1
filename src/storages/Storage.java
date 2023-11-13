package storages;

import elements.Element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;

public class Storage<T extends Element> {
    protected final Collection<T> storageItems;
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
        if (storageItems.size() >= size) return;
        storageItems.add(element);
        element.mount(this);
    }

    public void remove(T element){
        if (!storageItems.remove(element)) return;
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

    protected Collection<T> getStorageItems(){
        return storageItems;
    }
}
