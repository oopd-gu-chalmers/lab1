
public class BedComponent {
    private boolean bedUp;

    public BedComponent() {
        this.bedUp = true;
    }

    public boolean isBedUp() {
        return this.bedUp;
    }

    public void setBedState(boolean newState, double currentSpeed) {
        if (currentSpeed == 0) {
            this.bedUp = newState;
        } else {
            throw new IllegalArgumentException("Stop to move the bed");
        }
    }
}
