package assets.storages;

import assets.elements.Element;

import java.util.Collection;
import java.util.HashSet;

/**
 * A Storage can store Elements of a generic type.
 * The elements will keep the position of the storage they are mounted to.
 * @param <T> the type the storage can store
 */
public class Storage<T extends Element> {
    private final Collection<T> storageItems;
    private final Element owner;
    private final int size;

    protected Storage(Collection<T> storageItems, Element owner, int size){
        this.storageItems = storageItems;
        this.owner = owner;
        this.size = size;
    }

    /**
     * Create a new Storage
     * @param owner element containing the storage
     * @param size maximum amount of elements allowed in the storage
     */
    public Storage(Element owner, int size){
        this.storageItems = new HashSet<>();
        this.owner = owner;
        this.size = size;
    }

    /**
     * Add an element to the storage
     * @param element element to add
     */
    public void add(T element){
        if (storageItems.size() >= size){
            System.out.printf("%s is full%n", getOwner());
            return;
        }
        storageItems.add(element);
        element.mount(this);
    }

    /**
     * Remove an element from the storage
     * @param element element to remove
     */
    public void remove(T element){
        if (!storageItems.remove(element)) {
            System.out.printf("%s does not contain %s%n", getOwner(), element);
            return;
        }
        element.demount();
    }

    /**
     * Remove an element from the storage at a given position
     * @param element element to remove
     * @param position new position of the element
     */
    public void remove(T element, double[] position){
        if (!storageItems.remove(element)) return;
        element.demount(position);
    }

    /**
     * @return the owner of the element
     */
    public Element getOwner(){
        return owner;
    }

    /**
     * @return the maximum number of elements the storage can hold
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the current number of elements in the storage
     */
    public int getItemCount(){
        return storageItems.size();
    }

    /**
     * @return all current elements of the storage
     */
    public Collection<T> getStorageItems(){
        return storageItems;
    }
}
