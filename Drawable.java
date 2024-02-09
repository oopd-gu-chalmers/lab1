import java.awt.*;
import java.awt.image.BufferedImage;

public interface Drawable {
    BufferedImage getImage();
    Point getPosition();
    void setPosition();
    void setImage();

}
