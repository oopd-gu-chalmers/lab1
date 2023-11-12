package elements;

public interface Mountable {
    void mount(ActiveElement element);
    void demount();
    boolean isMounted();
}
