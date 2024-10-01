package inputs.types;

import game.player.Player;
import inputs.PlayerInput;
import objects.WallObject;
import objects.WaterObject;

public class UpKey extends PlayerInput {

    @Override
    public void onKeyPressed() {

        if (Player.getYPosition() > 0) {
            if (Player.getTileAtPositionNorth() instanceof WallObject) {
                return;
            }

            if (Player.getTileAtPosition() instanceof WaterObject) {
                Player.setImage(Player.waterImageLeft);
            } else {

                if (!Player.isIsRunning()) {
                    Player.setImage(Player.leftImage);
                }
            }

            Player.setYPosition(Player.getYPosition() - (10 + Player.getSpeed()));
            Player.setCameraOffsetY(Math.max(Player.cameraOffsetY - (10 + Player.getSpeed()), 0));
        }
    }

    @Override
    public void onKeyReleased() {

    }
}
