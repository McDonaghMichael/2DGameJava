package objects;

import java.awt.*;

public interface GameObject {
    int getID();
    void setID(int id);
    int getX();
    void setX(int x);
    void setY(int y);
    int getY();
    String getName();
    Image getImage();
    void draw(Graphics g, int cameraOffsetX, int cameraOffsetY);
}