package world;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tile {
    private int x, y;
    private int width, height;
    private Image image;

    public Tile(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.image = image;
    }

    private void loadImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.err.println("Error loading image: " + imagePath);
            e.printStackTrace();
        }
    }

    public void draw(Graphics g, int cameraOffsetX, int cameraOffsetY) {
        if (image != null) {
            g.drawImage(image, x - cameraOffsetX, y - cameraOffsetY, width, height, null);
        } else {
            g.setColor(Color.RED);
            g.fillRect(x - cameraOffsetX, y - cameraOffsetY, width, height);
        }
    }}