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
    private static List<GameObject> tiles;

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
            grassImages.add(ImageIO.read(new File("src/res/objects/grass6.png")));
            grassImages.add(ImageIO.read(new File("src/res/objects/grass7.png")));
            grassImages.add(ImageIO.read(new File("src/res/objects/grass8.png")));

            waterImages = new ArrayList<>();
            waterImages.add(ImageIO.read(new File("src/res/objects/water1.png")));

            dirtImages = new ArrayList<>();
            dirtImages.add(ImageIO.read(new File("src/res/objects/dirt1.png")));

            wallImages = new ArrayList<>();
            wallImages.add(ImageIO.read(new File("src/res/objects/wall1.png")));


        } catch (IOException e) {
            System.err.println("Error loading grass image");
            e.printStackTrace();
        }
    }

    private void createTiles() {
        Random rand = new Random();
        for (int i = 0; i < Player.getHighestXPosition(); i++) {
            for (int j = 0; j < Player.getHighestYPosition(); j++) {
                Image randomGrassImage = grassImages.get(rand.nextInt(grassImages.size()));
                GrassObject tile = new GrassObject(i * 50, j * 50, randomGrassImage);
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

    public static GameObject getTileAtPosition(int x, int y) {
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
