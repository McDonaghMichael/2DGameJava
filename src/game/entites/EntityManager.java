package game.entites;


import game.entites.types.Cow;

import javax.swing.*;
import java.awt.*;

public class EntityManager {

    private static Cow cow;
    private static Timer movementTimer;

    public EntityManager() {
        cow = new Cow(850, 850, 50, 50);

        cow.setXPosition(cow.getXPosition() + 50);
        System.out.println("Cow's X position: " + cow.getXPosition());



    }

    public static void drawEntities(Graphics g, int cameraOffsetX, int cameraOffsetY) {
     //   cow.draw(g, cameraOffsetX, cameraOffsetY);



    }

}
