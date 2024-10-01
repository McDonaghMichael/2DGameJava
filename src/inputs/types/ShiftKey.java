package inputs.types;

import game.player.Player;
import inputs.PlayerInput;
import objects.WallObject;
import objects.WaterObject;

public class ShiftKey extends PlayerInput {

    @Override
    public void onKeyPressed() {
        Player.setSpeed(10);
        switch (Player.getDirection()){
            case 0:
                Player.setImage(Player.leftImageSprint);

                break;
            case 1:
                Player.setImage(Player.rightImageSprint);
                break;
        }
        Player.setIsRunning(true);
    }

    @Override
    public void onKeyReleased() {
        Player.setSpeed(0);
        switch (Player.getDirection()){
            case 0:
                Player.setImage(Player.leftImage);
                break;
            case 1:
                Player.setImage(Player.rightImage);
                break;
        }
        Player.setIsRunning(false);
    }
}
