import game.GameWindow;
import game.entites.EntityManager;

import java.awt.*;

public class Main {

    static Dimension dimension;

    public static int screenWidth;
    public static int screenHeight;

    public static void main(String[] args) {

        dimension = Toolkit.getDefaultToolkit().getScreenSize();


        //Game.load(dimension, screenWidth, screenHeight);


        GameWindow gameWindow = new GameWindow(dimension, dimension.width, dimension.height);



    }
}