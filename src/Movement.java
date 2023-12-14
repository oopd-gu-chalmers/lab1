public class Movement implements Movable {
    private double[] position;
    private double[] direction;
    private double currentSpeed = 0;
    public double[] getPosition() {
        return position;
    }
    public double[] getDirection() {
        return direction;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public void setPosition(double[] position) {
        this.position = position;
    }
    public void setDirection(double[] direction) {
        this.direction = direction;
    }
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    public Movement() {
        position = new double[]{0, 0};
        direction = new double[]{1, 0};
    }

    public Movement(double[] position, double[] direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move() {
        //Ändrar x eller y baserat på riktning
        position[0] = position[0] + currentSpeed * direction[0];
        position[1] = position[1] + currentSpeed * direction[1];
    }

    public void turnLeft() {
        //Roterar den 90 grader åt vänster
        double x = direction[0];
        double y = direction[1];
        direction[0] = -y;
        direction[1] = x;
    }

    public void turnRight() {
        //Roterar den 90 grader åt höger
        double x = direction[0];
        double y = direction[1];
        direction[0] = y;
        direction[1] = -x;
    }
}