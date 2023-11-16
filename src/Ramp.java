public class Ramp {
    private int rampAngle;
    private final int maxRampAngle;
    public Ramp(int maxRampAngle){
        this.maxRampAngle = maxRampAngle;
        this.rampAngle = 0;
    }
    public void raiseRamp(int angle){
        this.rampAngle = Math.max(this.rampAngle - angle, 0);
    }
    public void lowerRamp(int angle){
        this.rampAngle = Math.min(this.rampAngle + angle, this.maxRampAngle);
    }
    public void raiseRamp(){
        this.rampAngle = 0;
    }
    public void lowerRamp(){
        this.rampAngle = this.maxRampAngle;
    }
    public int getRampAngle() {
        return this.rampAngle;
    }
}
