package inputs.types;

import game.player.Player;
import inputs.PlayerInput;
import objects.WallObject;
import objects.WaterObject;
import world.WorldConstants;

public class RightKey extends PlayerInput {

    @Override
    public void onKeyPressed() {

        if (Player.getXPosition() < WorldConstants.WORLD_X_BORDER - Player.getWidth()) {
            if (Player.getTileAtPositionEast() instanceof WallObject) {
                return;
            }
            if (Player.getTileAtPosition() instanceof WaterObject) {
                Player.setImage(Player.waterImageRight);

            } else {
                if(!Player.isIsRunning()) {
                    Player.setImage(Player.rightImage);
                }
            }
            Player.setDirection(1);
            Player.setXPosition(Player.getXPosition() + (10 + Player.getSpeed()));
            Player.setCameraOffsetX(Math.min(Player.cameraOffsetX + (10 + Player.getSpeed()), WorldConstants.WORLD_X_BORDER - Player.getWidth()));
          //  System.out.println("Player Position X: " + Player.getXPosition() + " Y: " + Player.getYPosition());


        }
    }
    @Override
    public void onKeyReleased() {

    }
}
