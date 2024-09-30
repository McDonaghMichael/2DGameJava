package game.entites;

import javax.swing.*;
import java.awt.*;

public class EntityTask implements Runnable {

    private Entity entity;
    private JPanel panel;
    private Timer timer;
    private Graphics g;

    public EntityTask(JPanel panel, Entity e, Graphics g) {
        this.entity = e;
        this.panel = panel;
        this.g = g;
    }

    @Override
    public void run() {
        // Create a Swing Timer that updates the entity's position and repaints the panel
        timer = new Timer(1000, e -> {
            // Move the entity by 50px every second
            this.entity.setXPosition(this.entity.getXPosition() + 50);
            System.out.println("Cow's X position: " + this.entity.getXPosition());

            // Repaint the panel to reflect the updated position
            this.panel.repaint();
        });


        timer.setInitialDelay(0);
        timer.start();

        Timer stopTimer = new Timer(5000, e -> timer.stop());
        stopTimer.setRepeats(false);
        stopTimer.start();
    }
}
