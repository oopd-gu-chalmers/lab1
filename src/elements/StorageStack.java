package elements;

public interface StorageStack<T extends ActiveElement> extends Storage {
    void addElement(T element);
    void removeElement();

}
