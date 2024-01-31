public class BedWithAngleComponent {

    private double bedAngle;

    public BedWithAngleComponent() {
        this.bedAngle = 0;
    }

    protected double getBedAngle(){
        return this.bedAngle;
    }

    protected void setBedAngle(double newBedAngle, double currentSpeed){
        if (currentSpeed != 0){
            throw new IllegalArgumentException("Please stop to change bed angle to 0");
        }
        else if (newBedAngle >= 0 && newBedAngle <= 70){
            this.bedAngle = newBedAngle;
        }
        else {
            throw new IllegalArgumentException("Bed angle not in correct interval");
        }
    }
}
