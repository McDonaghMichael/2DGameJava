package objects;

import world.WorldConstants;

import java.awt.*;

public class PlayerObject implements GameObject {

    private int id;
    private int x, y;
    private int width, height;
    private String name = "Player";
    private Image image;

    public PlayerObject(int x, int y, Image image) {
        this.id = ObjectIDList.PLAYER_OBEJCT;
        this.x = x;
        this.y = y;
        this.width = WorldConstants.TILE_SIZE;
        this.height = WorldConstants.TILE_SIZE;
        this.image = image;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void setID(int id) {

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

    public String getName() {
        return this.name;
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