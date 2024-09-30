package objects;

import java.awt.*;

public class WaterObject implements GameObject{
    private int x, y;
    private int width, height;
    private String name = "Water";
    private Image image;

    public WaterObject(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return this.name;
    }
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, int cameraOffsetX, int cameraOffsetY) {
        if (image != null) {
            g.drawImage(image, x - cameraOffsetX, y - cameraOffsetY, width, height, null);
        } else {
            g.setColor(Color.RED);
            g.fillRect(x - cameraOffsetX, y - cameraOffsetY, width, height);
        }
    }}