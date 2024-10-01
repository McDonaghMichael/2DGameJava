package inputs.types;

import game.GameWindow;
import inputs.PlayerInput;

public class IKey extends PlayerInput {

    @Override
    public void onKeyPressed() {
        if(GameWindow.getInventoryUI().isVisible()) {
            GameWindow.getInventoryUI().setVisible(false);
        }else{
            GameWindow.getInventoryUI().setVisible(true);
        }
    }

    @Override
    public void onKeyReleased() {

    }
}