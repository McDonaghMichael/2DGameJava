package game;

public class Player {

    private static int xPosition;
    private static int yPosition;
    private static int width;
    private static int height;
    private static int speed;

    public Player(int xPosition, int yPosition, int width, int height) {
        Player.xPosition = xPosition;
        Player.yPosition = yPosition;
        Player.width = width;
        Player.height = height;
        Player.speed = 0;
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
        return Player.getYPosition() + 2;
    }

    public static int getHighestXPosition() {
        return Player.getXPosition() + 2;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Player.speed = speed;
    }

}
