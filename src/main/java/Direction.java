import java.awt.geom.Point2D;

public enum Direction {
    NORTH(Math.PI / 2),
    EAST(0),
    SOUTH(3 * Math.PI / 2),
    WEST(Math.PI);

    private static final Direction[] directions = values();
    private final Point2D.Double unitDirectionPoint;

    Direction(Point2D.Double unitDirectionPoint) {
        this.unitDirectionPoint = unitDirectionPoint;
    }

    Direction(double angle) {
        this(new Point2D.Double(Math.cos(angle), Math.sin(angle)));
    }

    public Direction getNext() {
        return directions[(this.ordinal() + 1) % directions.length];
    }

    public Direction getPrevious() {
        return directions[(this.ordinal() - 1) % directions.length];
    }

    public Point2D.Double getUnitDirectionPoint() {
        return unitDirectionPoint;
    }
}
