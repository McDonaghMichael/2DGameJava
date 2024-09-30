package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player {

    private static int xPosition;
    private static int yPosition;
    private static int width;
    private static int height;
    private static int speed;
    public static Image image, leftImage, rightImage;

    public Player(int xPosition, int yPosition, int width, int height) {
        Player.xPosition = xPosition;
        Player.yPosition = yPosition;
        Player.width = width;
        Player.height = height;
        Player.speed = 10;
        try {
            Player.leftImage = ImageIO.read(new File("src/res/player_left.png"));
            Player.rightImage = ImageIO.read(new File("src/res/player_right.png"));
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
}
