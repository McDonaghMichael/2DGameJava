package game;

import java.awt.*;

public class Main {

    static Dimension dimension;

    public static int screenWidth;
    public static int screenHeight;

    public static void main(String[] args) {

        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = dimension.width;
        screenHeight = dimension.height;

        GameWindow gameWindow = new GameWindow(dimension, dimension.width, dimension.height);

    }
}