import java.util.ArrayList;

import static java.lang.Math.abs;

public class Storage<T extends Object> extends Object {
    private ArrayList<T> storageContents;
    private final int maxLoadAmount;

    public Storage(int maxLoadAmount){
        storageContents = new ArrayList<T>();
        this.maxLoadAmount = maxLoadAmount;
    }
    private boolean overlaps(T car){
        return (abs(this.getPositionX() - car.getPositionX()) < 1) && (abs(this.getPositionY() - car.getPositionY()) < 1);
    }
    public void loadCar(T car){
        if(storageContents.size() < maxLoadAmount && overlaps(car)) {
            storageContents.add(car);

        }
        else {
            System.out.println("The truck is full");
        }
    }
    public T unloadCar(){
        T last = storageContents.getLast();
        storageContents.removeLast();
        return last;
    }
    public void getStorage(){
        if (storageContents.size() == 1){
            System.out.println("There is no Vehicles on the truck");
        }
        for (int i = 1; i < storageContents.size(); i++){
            System.out.println("This Vehicle is on the truck: " + storageContents.get(i));
        }
    }
    public int getStorageSize(){
        return storageContents.size();
    }

    public void moveStoredCars() {
        for (T car : storageContents) {
            car.setPosition(this.getPositionX(), this.getPositionY());
        }
    }
}
