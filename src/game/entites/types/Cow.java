package game.entites.types;

import game.entites.Entity;
import game.player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Cow implements Entity {

    private String name = "Cow";
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private int speed;
    private int direction;
    public boolean isRunning;
    public Image image, leftImage, rightImage;

    public Cow(int xPosition, int yPosition, int width, int height) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.speed = 10;
        this.direction = 0;
        Player.isRunning = false;
        try {
            this.leftImage = ImageIO.read(new File("src/res/cow_left.png"));
            this.rightImage = ImageIO.read(new File("src/res/cow_right.png"));
            this.image = this.leftImage;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Image getRightImage() {
        return rightImage;
    }

    public void setRightImage(Image rightImage) {
        this.rightImage = rightImage;
    }

    public Image getLeftImage() {
        return leftImage;
    }

    public void setLeftImage(Image leftImage) {
        this.leftImage = leftImage;
    }

    @Override
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getYPosition() {
        return yPosition;
    }

    @Override
    public void setYPosition() {

    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    @Override
    public void draw(Graphics g, int cameraOffsetX, int cameraOffsetY) {
        if (image != null) {
            g.drawImage(image, this.getYPosition() - cameraOffsetX, this.getYPosition() - cameraOffsetY, this.width, this.height, null);
        } else {
            g.setColor(Color.RED);
            g.fillRect(this.getXPosition() - cameraOffsetX, this.getYPosition() - cameraOffsetY, width, height);
        }
    }
    }
