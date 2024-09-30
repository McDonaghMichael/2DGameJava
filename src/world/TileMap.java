package world;

import world.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.Player;

public class TileMap {
    private List<Tile> tiles;
    private Image grassImage;
    ArrayList<BufferedImage> grassImages;

    public TileMap() {
        tiles = new ArrayList<>();
        loadGrassImage();
        createTiles();
    }

    private void loadGrassImage() {
        try {
            grassImages = new ArrayList<>();
            grassImages.add(ImageIO.read(new File("src/res/grass1.png")));
            grassImages.add(ImageIO.read(new File("src/res/grass2.png")));
            grassImages.add(ImageIO.read(new File("src/res/grass3.png")));

             // Load the image once
            System.out.println("Grass image loaded successfully!"); // Debugging line
        } catch (IOException e) {
            System.err.println("Error loading grass image");
            e.printStackTrace();
        }
    }

    private void createTiles() {
        for (int i = 0; i < Player.getHighestXPosition(); i++) { // 10 tiles wide
            for (int j = 0; j < Player.getHighestYPosition(); j++) { // 10 tiles tall
                Random rand = new Random();
                grassImage = grassImages.get(rand.nextInt(3));
                tiles.add(new Tile(i * 50, j * 50, grassImage)); // Pass the loaded image
            }
        }
    }

    public void draw(Graphics g, int cameraOffsetX, int cameraOffsetY) {
        for (Tile tile : tiles) {
            tile.draw(g, cameraOffsetX, cameraOffsetY);
        }
    }
}
