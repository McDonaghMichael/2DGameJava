package game.player;

import objects.GameObject;
import world.TileMap;
import world.WorldConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player {

    private static int xPosition;
    private static int yPosition;
    public static int cameraOffsetX;
    public static int cameraOffsetY;
    private static int width;
    private static int height;
    private static int speed;
    private static int direction;
    private static int health;
    private static int saturation;
    private static int energy;
    public static boolean isRunning;
    public static GameObject currentObject;
    public static Image image, leftImage, rightImage, waterImageLeft, waterImageRight, leftImageSprint, rightImageSprint;

    public Player(int xPosition, int yPosition, int width, int height) {
        Player.xPosition = xPosition;
        Player.yPosition = yPosition;
        Player.cameraOffsetX = 0;
        Player.cameraOffsetY = 0;
        Player.width = width;
        Player.height = height;
        Player.speed = 25;
        Player.direction = 0;
        Player.isRunning = false;
        Player.health = 10;
        Player.saturation = 10;
        Player.energy = 10;
        Player.currentObject = null;
        try {
            Player.leftImage = ImageIO.read(new File("src/res/entities/player/player_left.png"));
            Player.rightImage = ImageIO.read(new File("src/res/entities/player/player_right.png"));
            Player.waterImageLeft = ImageIO.read(new File("src/res/entities/player/player_water_left.png"));
            Player.waterImageRight = ImageIO.read(new File("src/res/entities/player/player_water_right.png"));
            Player.leftImageSprint = ImageIO.read(new File("src/res/entities/player/player_left_sprint.png"));
            Player.rightImageSprint = ImageIO.read(new File("src/res/entities/player/player_right_sprint.png"));
            Player.image = leftImage;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int getXPosition(){
        return xPosition;
    }

    public static void setXPosition(int xPosition) {
        Player.xPosition = xPosition;
    }

    public static int getYPosition() {
        return yPosition;
    }
    public static void setYPosition(int yPosition) {
        Player.yPosition = yPosition;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Player.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Player.height = height;
    }

    public static int getHighestYPosition() {
        return Player.getYPosition() + 100;
    }

    public static int getHighestXPosition() {
        return Player.getXPosition() + 100;
    }

    public static int getLowestYPosition() {
        return Player.getYPosition() - 100;
    }

    public static int getLowestXPosition() {
        return Player.getXPosition() - 2;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Player.speed = speed;
    }

    public static Image getImage() {
        return image;
    }

    public static void setImage(Image image) {
        Player.image = image;
    }

    public static int getDirection() {
        return direction;
    }

    public static void setDirection(int direction) {
        Player.direction = direction;
    }

    public static boolean isIsRunning() {
        return isRunning;
    }

    public static void setIsRunning(boolean isRunning) {
        Player.isRunning = isRunning;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public static int getSaturation() {
        return saturation;
    }

    public static void setSaturation(int saturation) {
        Player.saturation = saturation;
    }

    public static int getEnergy() {
        return energy;
    }

    public static void setEnergy(int energy) {
        Player.energy = energy;
    }

    public static GameObject getCurrentObject() {
        return currentObject;
    }

    public static void setCurrentObject(GameObject currentObject) {
        Player.currentObject = currentObject;
    }

    public static int getCameraOffsetY() {
        return cameraOffsetY;
    }

    public static void setCameraOffsetY(int cameraOffsetY) {
        Player.cameraOffsetY = cameraOffsetY;
    }

    public static int getCameraOffsetX() {
        return cameraOffsetX;
    }

    public static void setCameraOffsetX(int cameraOffsetX) {
        Player.cameraOffsetX = cameraOffsetX;
    }

    public static GameObject getTileAtPositionBasedOnDirection(){
        switch (Player.direction){
            case 0:
                return getTileAtPositionWest();
            case 1:
                return getTileAtPositionEast();
        }

        return getTileAtPositionEast();
    }

    public static int getPositionBasedOnDirection() {
        int currentXPosition = Player.getXPosition();
        int newPosition;

        switch (Player.direction) {
            case 0: // Moving left
                newPosition = currentXPosition - WorldConstants.TILE_SIZE;
                break;
            case 1: // Moving right
                newPosition = currentXPosition + WorldConstants.TILE_SIZE;
                break;
            default: // Default case, just return the current position
                return currentXPosition;
        }

        // Round to the nearest multiple of 50
        return Math.round(newPosition / 100.0f) * WorldConstants.TILE_SIZE;
    }


    public static GameObject getTileAtPositionWest(){
        return TileMap.getTileAtPosition(Player.getXPosition() - WorldConstants.TILE_SIZE, Player.getYPosition());
    }

    public static GameObject getTileAtPositionNorth(){
        return TileMap.getTileAtPosition(Player.getXPosition(), Player.getYPosition() - WorldConstants.TILE_SIZE);
    }

    public static GameObject getTileAtPositionEast(){
        return TileMap.getTileAtPosition(Player.getXPosition() + WorldConstants.TILE_SIZE, Player.getYPosition());
    }

    public static GameObject getTileAtPositionSouth(){
        return TileMap.getTileAtPosition(Player.getXPosition(), Player.getYPosition() + WorldConstants.TILE_SIZE);
    }

    public static GameObject getTileAtPosition(){
        return TileMap.getTileAtPosition(Player.getXPosition(), Player.getYPosition());
    }
}
