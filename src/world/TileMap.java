package world;

import objects.GameObject;
import objects.GrassObject;
import objects.WaterObject;
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
    private List<GameObject> tiles;

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
                Random rand = new Random();
                grassImage = grassImages.get(rand.nextInt(3));
                GrassObject tile = new GrassObject(i * 50, j * 50, grassImage);
                tiles.add(tile);

            }
        }

        generateLake();
    }

    private void generateLake() {
        waterImage = waterImages.get(new Random().nextInt(waterImages.size()));

        WaterObject water1 = new WaterObject(5 * 50, 4 * 50, waterImage);
        WaterObject water2 = new WaterObject(6 * 50, 4 * 50, waterImage);
        addTile(water1);
        addTile(water2);
    }

    public GameObject getTileAtPosition(int x, int y) {
        for (GameObject tile : tiles) {
            if (tile.getX() == x * 50 && tile.getY() == y * 50) {
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
                System.out.println("DOES EXIST");
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
