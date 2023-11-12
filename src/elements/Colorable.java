package elements;

import java.awt.*;

/**
 * A Colorable has a changeable color
 */
public interface Colorable {
    /**
     * Change the color
     * @param color new color
     */
    void setColor(Color color);

    /**
     * @return the current color
     */
    Color getColor();
}
