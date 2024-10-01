package inputs.types;

import game.GameWindow;
import inputs.PlayerInput;

public class TKey extends PlayerInput {

    @Override
    public void onKeyPressed() {
        if(GameWindow.getIndicatorsUI().isVisible()) {
            GameWindow.getIndicatorsUI().setVisible(false);
        }else{
            GameWindow.getIndicatorsUI().setVisible(true);
        }
    }

    @Override
    public void onKeyReleased() {

    }
}
