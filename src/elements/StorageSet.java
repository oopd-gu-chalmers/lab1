package elements;

public interface StorageSet<T extends ActiveElement> extends Storage {
    void addElement(T element);
    void removeElement(T element);
}