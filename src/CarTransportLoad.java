import java.util.Stack;

public class CarTransportLoad implements Load{
    protected Stack<Car> cargoStack;

    @Override
    public void load(Car car) {
        cargoStack.push(car);
    }

    @Override
    public Car unload() {
        return cargoStack.pop();
    }

    @Override
    public boolean noLoad(){
        return cargoStack.isEmpty();
    }
}
