package game.entites;

import java.awt.*;

public interface Entity {

    int getXPosition();
    void setXPosition(int i);
    int getYPosition();
    void setYPosition();
    int getWidth();
    int getHeight();
    String getName();
    Image getImage();
    void draw(Graphics g, int cameraOffsetX, int cameraOffsetY);
}