package world;

import objects.GameObject;
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
    private Image waterImage;

    ArrayList<BufferedImage> grassImages;
    ArrayList<BufferedImage> waterImages;

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

            waterImages = new ArrayList<>();
            waterImages.add(ImageIO.read(new File("src/res/water1.png")));

            System.out.println("Grass image loaded successfully!"); // Debugging line
        } catch (IOException e) {
            System.err.println("Error loading grass image");
            e.printStackTrace();
        }
    }

    private void createTiles() {
        for (int i = 0; i < Player.getHighestXPosition(); i++) {
            for (int j = 0; j < Player.getHighestYPosition(); j++) {

                if(i == 2000 && j == 2001) {
                    waterImage = waterImages.get(new Random().nextInt(waterImages.size()));
                    tiles.add(new Tile(i * 50, j * 50, waterImage));
                }else if(i == 2 && j == 1) {
                    waterImage = waterImages.get(new Random().nextInt(waterImages.size()));
                    tiles.add(new Tile(i * 50, j * 50, waterImage));
                }else if(i == 2 && j == 2) {
                    waterImage = waterImages.get(new Random().nextInt(waterImages.size()));
                    tiles.add(new Tile(i * 50, j * 50, waterImage));
                }else if(i == 3 && j == 1) {
                    waterImage = waterImages.get(new Random().nextInt(waterImages.size()));
                    tiles.add(new Tile(i * 50, j * 50, waterImage));
                }else{
                    Random rand = new Random();
                    grassImage = grassImages.get(rand.nextInt(3));
                    tiles.add(new Tile(i * 50, j * 50, grassImage)); // Pass the loaded image
                }



            }
        }
    }

    public void draw(Graphics g, int cameraOffsetX, int cameraOffsetY) {
        for (Tile tile : tiles) {

            tile.draw(g, cameraOffsetX, cameraOffsetY);
        }
    }
}
