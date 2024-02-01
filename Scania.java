import java.awt.*;

public class Scania extends Vehicle implements Platform {
    private double flatbedAngle;

    public Scania(){
        super(2, Color.blue, 400, "Scania"); // 2 doors, blue, 400 engine power
        this.flatbedAngle = 0;
    }

    public double getFlatbedAngle() {
        return flatbedAngle;
    }

    @Override
    public void raisePlatform() {
        if (getCurrentSpeed() == 0){
            flatbedAngle = Math.min(flatbedAngle + 10, 70);
        }
        else {
            throw new IllegalStateException("Cannot raise flatbed when moving!");
        }
    }

    @Override
    public void lowerPlatform() {
        if (getCurrentSpeed() == 0){
            flatbedAngle = Math.max(flatbedAngle - 10, 0);
        }
        else {
            throw new IllegalStateException("Cannot lower flatbed when moving!");
        }

    }

    @Override
    public void startEngine() {
        if (getFlatbedAngle() == 0) {
            super.startEngine();
        } else {
            throw new IllegalStateException("Cannot start engine with raised flatbed!");
        }
    }

    @Override
    double speedFactor() {
        return 0.1;
    }

    @Override
    public void incrementSpeed(double amount){
        if (getFlatbedAngle() == 0){
            super.incrementSpeed(amount);
        } else {
            throw new IllegalStateException("Cannot increase speed with raised flatbed!");
        }
    }


    // JUnit test case (for demonstration purposes)
    public static void main(String[] args) {
        // Create a Scania instance
        Scania scaniaTruck = new Scania();

        System.out.println("Initial conditions:");

        // Test getting flatbed angle
        System.out.println("Flatbed angle: " + scaniaTruck.getFlatbedAngle());

        // Test getting speed
        System.out.println("Current speed: " + scaniaTruck.getCurrentSpeed());



        System.out.println(" ");
        System.out.println("Testing raising and lowering flatbed when stationary:");

        // Test raising flatbed when stationary
        scaniaTruck.raisePlatform();
        System.out.println("Flatbed angle after raising: " + scaniaTruck.getFlatbedAngle());

        // Test lowering flatbed when stationary
        scaniaTruck.lowerPlatform();
        System.out.println("Flatbed angle after lowering: " + scaniaTruck.getFlatbedAngle());



        // Test starting engine with raised flatbed
        System.out.println(" ");
        System.out.println("Test starting engine with raised flatbed:");
        scaniaTruck.raisePlatform();
        scaniaTruck.startEngine();  // Should not start engine with raised flatbed



        // Test starting engine with lowered flatbed
        System.out.println(" ");
        System.out.println("Test starting engine with lowered flatbed:");
        scaniaTruck.lowerPlatform();
        scaniaTruck.startEngine();  // Should start engine with lowered flatbed
        System.out.println("Current speed with lowered flatbed: " + scaniaTruck.getCurrentSpeed());



        // Test raising flatbed when non-stationary
        System.out.println(" ");
        System.out.println("Test raising flatbed when non-stationary:");
        scaniaTruck.incrementSpeed(0.5);
        scaniaTruck.raisePlatform();  // Should not raise flatbed when non-stationary
    }


}
