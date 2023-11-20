public interface Platform {
    boolean platformIsFullyClosed();

    boolean platformIsFullyOpened();

    void closePlatform();

    void openPlatform();
}