package inputs.types;

import game.player.Player;
import inputs.PlayerInput;
import objects.WallObject;
import objects.WaterObject;
import world.WorldConstants;

public class DownKey extends PlayerInput {

    @Override
    public void onKeyPressed() {

        if (Player.getYPosition() < WorldConstants.WORLD_Y_BORDER - Player.getHeight() * 2) {
            if (Player.getTileAtPositionSouth() instanceof WallObject) {
                System.out.println("South: " + Player.getTileAtPositionSouth().getName());
                return;
            }

            if (Player.getTileAtPosition() instanceof WaterObject) {
                Player.setImage(Player.waterImageLeft);
            } else {

                if (!Player.isIsRunning()) {
                    Player.setImage(Player.leftImage);
                }
            }
            Player.setYPosition(Player.getYPosition() + (10 + Player.getSpeed()));
            Player.setCameraOffsetY(Math.min(Player.cameraOffsetY + (10 + Player.getSpeed()), WorldConstants.WORLD_Y_BORDER - Player.getHeight())); // Stop scrolling past the bottom edge
        } else {
            Player.setYPosition(WorldConstants.WORLD_Y_BORDER - Player.getHeight() * 2);
        }
    }

    @Override
    public void onKeyReleased() {

    }
}
