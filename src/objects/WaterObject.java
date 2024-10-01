package objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class WaterObject implements GameObject {
    private int x, y;
    private int width, height;
    private String name = "Water";
    private Image image;
    private ArrayList<BufferedImage> images = new ArrayList<>();

    public WaterObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        try{
            images.add(ImageIO.read(new File("src/res/objects/water1.png")));
            this.image = images.get(new Random().nextInt(images.size()));;
        }catch (Exception e){
            e.printStackTrace();
        }

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