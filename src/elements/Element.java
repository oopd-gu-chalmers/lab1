package elements;

/**
 * An Element has a position and a rotation, it can also move
 */
public abstract class Element implements Movable{
    private double[] position;
    private double rotation;
    private double speed = 0;

    /**
     * An element at {@code 0,0} with rotation {@code 0} degrees
     */
    public Element(){
        resetTransform();
    }

    /**
     * An element with specified transform
     * @param position the x,y position of the element
     * @param rotation the rotation of the element in degrees
     */
    public Element(double[] position, double rotation){
        this.position = position;
        this.rotation = rotation;
    }

    /**
     * Sets the position to {@code 0,0} and the rotation to {@code 0} degrees
     */
    public void resetTransform(){
        position = new double[]{0,0};
        rotation = 0;
    }

    /**
     * Change the position of the element
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void setPosition(double x, double y){
        position[0] = x;
        position[1] = y;
    }

    /**
     * Change the rotation of the element
     * @param rotation rotation in degrees
     */
    public void setRotation(double rotation){
        this.rotation = rotation;
    }

    /**
     * @return rotation in degrees
     */
    public double getRotation(){
        return rotation;
    }

    /**
     * @return x,y coordinate-pair
     */
    public double[] getPosition(){
        return position;
    }

    public double getSpeed(){
        return speed;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void moveTick(){
        double[] pos = getPosition();
        pos[0] += getSpeed() * Math.sin(Math.toRadians(getRotation()));
        pos[1] += getSpeed() * Math.cos(Math.toRadians(getRotation()));
        setPosition(pos[0], pos[1]);
    }

}
