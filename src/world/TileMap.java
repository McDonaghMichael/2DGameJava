package world;

import objects.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.player.Player;

public class TileMap {
    private List<GameObject> tiles;

    private Image grassImage;
    private Image waterImage;
    private Image dirtImage;
    private Image wallImage;
    private Image cowImage;

    ArrayList<BufferedImage> grassImages;
    ArrayList<BufferedImage> waterImages;
    ArrayList<BufferedImage> dirtImages;
    ArrayList<BufferedImage> wallImages;
    ArrayList<BufferedImage> cowImages;

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
            grassImages.add(ImageIO.read(new File("src/res/grass4.png")));
            grassImages.add(ImageIO.read(new File("src/res/grass5.png")));
            grassImages.add(ImageIO.read(new File("src/res/grass6.png")));
            grassImages.add(ImageIO.read(new File("src/res/grass7.png")));
            grassImages.add(ImageIO.read(new File("src/res/grass8.png")));

            waterImages = new ArrayList<>();
            waterImages.add(ImageIO.read(new File("src/res/water1.png")));

            dirtImages = new ArrayList<>();
            dirtImages.add(ImageIO.read(new File("src/res/dirt1.png")));

            wallImages = new ArrayList<>();
            wallImages.add(ImageIO.read(new File("src/res/wall1.png")));


        } catch (IOException e) {
            System.err.println("Error loading grass image");
            e.printStackTrace();
        }
    }

    private void createTiles() {
        for (int i = 0; i < Player.getHighestXPosition(); i++) {
            for (int j = 0; j < Player.getHighestYPosition(); j++) {
                Random rand = new Random();
                grassImage = grassImages.get(rand.nextInt(7));
                GrassObject tile = new GrassObject(i * 50, j * 50, grassImage);
                tiles.add(tile);

            }
        }

        generateLake();
    }

    private void generateLake() {
        waterImage = waterImages.get(new Random().nextInt(waterImages.size()));
        dirtImage = dirtImages.get(new Random().nextInt(dirtImages.size()));
        wallImage = wallImages.get(new Random().nextInt(wallImages.size()));

        addTile(new WaterObject(5 * 50, 4 * 50, waterImage));
        addTile(new WaterObject(6 * 50, 4 * 50, waterImage));
        addTile(new DirtObject(5 * 50, 5 * 50, dirtImage));
        addTile(new DirtObject(6 * 50, 5 * 50, dirtImage));
        addTile(new DirtObject(5 * 50, 7 * 50, dirtImage));
        addTile(new DirtObject(5 * 50, 8 * 50, dirtImage));
        addTile(new WallObject(10 * 50, 10 * 50, wallImage));

    }

    public GameObject getTileAtPosition(int x, int y) {
        for (GameObject tile : tiles) {
            if (tile.getX() == x && tile.getY()  == y) {
                return tile;
            }
        }
        return null;
    }

    public void addTile(GameObject tile) {
        tiles.add(tile);
        removeOccupied(tile);
    }

    public void removeOccupied(GameObject t) {

        List<GameObject> occupied = new ArrayList<>();
        for (GameObject tile : tiles) {
            if (tile.getX() == t.getX() && tile.getY() == t.getY()) {
                occupied.add(tile);
                break;
            }
        }

        for (GameObject grass : occupied) {
            tiles.remove(grass);
        }
    }
    public void draw(Graphics g, int cameraOffsetX, int cameraOffsetY) {
        for (GameObject tile : tiles) {
            tile.draw(g, cameraOffsetX, cameraOffsetY);
        }
    }
}
