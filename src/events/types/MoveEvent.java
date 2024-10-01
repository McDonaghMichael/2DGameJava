package events.types;

import events.Event;
import game.player.Player;
import objects.GameObject;
import objects.WallObject;
import objects.WaterObject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MoveEvent extends Event {

    private int xPosition, yPosition;

    private Player player;

    public MoveEvent(Player player, int xPosition, int yPosition) {
        this.player = player;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public void execute() {

        if (isCancelled()) {
            return;
        }



    }
}