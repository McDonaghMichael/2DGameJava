package objects;

import java.awt.*;

public interface GameObject {
    int getX();
    int getY();
    String getName();
    Image getImage();
    void draw(Graphics g, int cameraOffsetX, int cameraOffsetY);
}