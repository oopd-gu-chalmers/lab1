public class BedWithAngleComponent {

    private double bedAngle;

    public BedWithAngleComponent() {
        this.bedAngle = 0;
    } //konstruktor

    protected boolean isBedUp(){
        return bedAngle == 0;
    }

    protected boolean isBedDown(){
        return bedAngle == 70;
    }

    protected void raiseBed(double currentSpeed){
        if (currentSpeed != 0){
            throw new IllegalArgumentException("Please stop to raise bed");
        }
        else if (bedAngle == 0){
            throw new IllegalArgumentException("Bed is already up");
        }
        else {
            this.bedAngle = 0;
        }
    }

    protected void lowerBed(double currentSpeed){
        if (currentSpeed != 0){
            throw new IllegalArgumentException("Please stop to lower bed");
        }
        else if (bedAngle == 70){
            throw new IllegalArgumentException("Bed is already down");
        }
        else {
            this.bedAngle = 70;
        }
    }
}
