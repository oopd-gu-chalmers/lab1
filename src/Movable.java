interface Movable {
    void setPosition(double[] position);
    double[] getPosition();
    void setCurrentSpeed(double currentSpeed);
    double getCurrentSpeed();
    void move();
    void turnLeft();
    void turnRight();
}
