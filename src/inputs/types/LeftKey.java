package inputs.types;

import game.player.Player;
import inputs.PlayerInput;
import objects.WallObject;
import objects.WaterObject;

public class LeftKey extends PlayerInput {

    @Override
    public void onKeyPressed() {

        if (Player.getXPosition() > 0) {
            if (Player.getTileAtPositionWest() instanceof WallObject) {
                return;
            }
            if (Player.getTileAtPosition() instanceof WaterObject) {
                Player.setImage(Player.waterImageLeft);
            } else {

                if (!Player.isIsRunning()) {
                    Player.setImage(Player.leftImage);
                }

            }

            Player.setXPosition(Player.getXPosition() - (10 + Player.getSpeed()));
            Player.setCameraOffsetX(Math.max(Player.cameraOffsetX - (10 + Player.getSpeed()), 0));
            Player.setDirection(0);

        //    System.out.println("Player Position X: " + Player.getXPosition() + " Y: " + Player.getYPosition());
        }
    }
    @Override
    public void onKeyReleased() {
    }
}
