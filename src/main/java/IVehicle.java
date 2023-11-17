import java.awt.*;

public interface IVehicle {
    double getEnginePower();

    double getCurrentSpeed();

    Color getColor();

    void setColor(Color clr);

    String getModelName();

    void startEngine();

    void stopEngine();

    // TODO fix this method according to lab pm
    void gas(double amount);

    // TODO fix this method according to lab pm
    void brake(double amount);

    boolean engineIsRunning();

    int getNrDoors();
}
