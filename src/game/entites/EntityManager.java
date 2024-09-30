package game.entites;

import game.Game;
import game.entites.types.Cow;

import javax.swing.*;
import java.awt.*;

public class EntityManager {

    static Game game;
    private static Cow cow;
    private static Timer movementTimer;

    public EntityManager(Game game) {
        cow = new Cow(850, 850, 50, 50);
        this.game = game;
        cow.setXPosition(cow.getXPosition() + 50);
        System.out.println("Cow's X position: " + cow.getXPosition());

        // Repaint the panel to reflect the updated position
        game.repaint();

    }

    public static void drawEntities(Graphics g, int cameraOffsetX, int cameraOffsetY) {
        cow.draw(g, cameraOffsetX, cameraOffsetY);



    }

}
