package src;

import java.util.Stack;

public interface Storage {
    Stack<Car> cargo = new Stack<>();
    int maxsize = 0;
    void loadCargo(Car car);
    void offLoadCargo();
}
// Kan man verkligen initiera dessa variabler såhär?
// Är det bättre att göra detta som en klass som verkstad och transport ärver?
// Kan man ens "dubbel"-ärva?
// Göra public så att man kanske kan ändra position automatiskt?
