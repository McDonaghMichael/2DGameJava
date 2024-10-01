package game.player;

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
    public static boolean isRunning;
    public static Image image, leftImage, rightImage, waterImageLeft, waterImageRight, leftImageSprint, rightImageSprint;

    public Player(int xPosition, int yPosition, int width, int height) {
        Player.xPosition = xPosition;
        Player.yPosition = yPosition;
        Player.cameraOffsetX = 0;
        Player.cameraOffsetY = 0;
        Player.width = width;
        Player.height = height;
        Player.speed = 10;
        Player.direction = 0;
        Player.isRunning = false;
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
}
