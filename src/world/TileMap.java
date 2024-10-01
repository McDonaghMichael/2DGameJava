package world;

import game.GameWindow;
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

    private static GameWindow window;

    public static ArrayList<BufferedImage> grassImages;

    public TileMap(GameWindow window) {
        this.window = window;
        tiles = new ArrayList<>();
        createTiles();

    }

    private void createTiles() {
        Random rand = new Random();
        for (int i = 0; i < Player.getHighestXPosition(); i++) {
            for (int j = 0; j < Player.getHighestYPosition(); j++) {
                GrassObject tile = new GrassObject(i * 50, j * 50);
                tiles.add(tile);
            }
        }


        generateLake();
    }

    private void generateLake() {

        addTile(new WaterObject(5 * 50, 4 * 50));
        addTile(new WaterObject(6 * 50, 4 * 50));
        addTile(new DirtObject(5 * 50, 5 * 50));
        addTile(new DirtObject(6 * 50, 5 * 50));
        addTile(new DirtObject(5 * 50, 7 * 50));
        addTile(new DirtObject(5 * 50, 8 * 50));
        addTile(new WallObject(10 * 50, 10 * 50));

    }

    public static GameObject getTileAtPosition(int x, int y) {
        for (GameObject tile : tiles) {
            if (tile.getX() == x && tile.getY() == y) {
                System.out.println("Tile Position X: " + tile.getX() + " Y: " + tile.getY() + " Name: " + tile.getName());
                return tile;
            }
        }
        return null;
    }

    public static void addTile(GameObject tile) {
        removeOccupied(tile);
        tiles.add(tile);

    }

    public static void removeOccupied(GameObject t) {

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
